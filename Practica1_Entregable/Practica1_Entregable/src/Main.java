public class Main {

    private static java.io.BufferedReader entrada =
            new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    private static Mascota[] mascotas = new Mascota[10];
    private static int cantidadMascotas = 0;

    public static void main(String[] args) throws java.io.IOException {

        boolean salir = false;

        while (!salir) {

            mostrarMenu();
            String opcion = entrada.readLine();

            switch (opcion) {

                case "1":
                    registrarMascota();
                    break;

                case "2":
                    asociarDispositivo();
                    break;

                case "3":
                    registrarUbicacion();
                    break;

                case "4":
                    consultarMascota();
                    break;

                case "5":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        }
    }

    private static void mostrarMenu() {

        System.out.println("===== Bienvenido al menu =====");
        System.out.println("1) Registrar mascota");
        System.out.println("2) Asociar dispositivo");
        System.out.println("3) Registrar ubicación");
        System.out.println("4) Consultar información");
        System.out.println("5) Salir");
        System.out.print("Seleccione opción: ");
    }

    private static void registrarMascota() throws java.io.IOException {

        System.out.print("Ingrese ID de la mascota: ");
        String id = entrada.readLine();

        System.out.print("Nombre: ");
        String nombre = entrada.readLine();

        System.out.print("Especie: ");
        String especie = entrada.readLine();

        Mascota mascota = new Mascota(id, nombre, especie);
        agregarMascota(mascota);

        System.out.println("Mascota registrada.");
    }

    private static void asociarDispositivo() throws java.io.IOException {

        Mascota mascota = buscarMascotaPorId();

        if (mascota == null) {
            System.out.println("Mascota no encontrada.");
            return;
        }

        if (mascota.getDispositivoAsociado() != null) {
            System.out.println("La mascota ya tiene dispositivo.");
            return;
        }

        System.out.print("Código dispositivo: ");
        String codigo = entrada.readLine();

        DispositivoLocalizacion dispositivo =
                new DispositivoLocalizacion(codigo);

        mascota.setDispositivoAsociado(dispositivo);

        System.out.println("Dispositivo asociado.");
    }

    private static void registrarUbicacion() throws java.io.IOException {

        Mascota mascota = buscarMascotaPorId();

        if (mascota == null) {
            System.out.println("Mascota no encontrada.");
            return;
        }

        DispositivoLocalizacion dispositivo =
                mascota.getDispositivoAsociado();

        if (dispositivo == null) {
            System.out.println("La mascota no tiene dispositivo.");
            return;
        }

        System.out.print("Ingrese ID del registro: ");
        String idRegistro = entrada.readLine();

        System.out.print("Fecha y hora: ");
        String fechaHora = entrada.readLine();

        System.out.print("Dirección: ");
        String direccion = entrada.readLine();

        RegistroUbicacion registro =
                new RegistroUbicacion(idRegistro, fechaHora, direccion);

        dispositivo.agregarRegistroUbicacion(registro);

        System.out.println("Ubicación registrada.");
    }

    private static void consultarMascota() throws java.io.IOException {

        Mascota mascota = buscarMascotaPorId();

        if (mascota == null) {
            System.out.println("Mascota no encontrada.");
            return;
        }

        System.out.println(mascota);
    }

    private static Mascota buscarMascotaPorId() throws java.io.IOException {

        System.out.print("Ingrese ID de la mascota: ");
        String id = entrada.readLine();

        for (int i = 0; i < cantidadMascotas; i++) {
            if (mascotas[i].getIdentificador().equals(id)) {
                return mascotas[i];
            }
        }

        return null;
    }

    private static void agregarMascota(Mascota mascota) {

        if (cantidadMascotas == mascotas.length) {

            Mascota[] nuevo = new Mascota[mascotas.length * 2];

            for (int i = 0; i < mascotas.length; i++) {
                nuevo[i] = mascotas[i];
            }

            mascotas = nuevo;
        }

        mascotas[cantidadMascotas] = mascota;
        cantidadMascotas++;
    }
}