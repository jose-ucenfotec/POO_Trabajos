public class Main {

    public static void main(String[] args) {

        // Pasaportes
        Pasaporte pasaporte1 = new Pasaporte("P001", "Costa Rica", "01-01-2024", "01-01-2034", true);
        Pasaporte pasaporte2 = new Pasaporte("P002", "Costa Rica", "01-01-2010", "01-01-2020", false);

        // Personas
        Persona persona1 = new Persona("Romario", "Salas Cerdas");
        Persona persona2 = new Persona("Ana", "Lopez Perez");

        persona1.sacarPasaporte(pasaporte1);
        persona2.sacarPasaporte(pasaporte2);

        // Mascota compartida
        Mascota mascota = new Mascota("Aoki", "Perro", 3);
        persona1.adoptarMascota(mascota);
        persona2.adoptarMascota(mascota);

        // Máquina de soldar
        String[] metales = {"hierro", "acero"};
        MaquinaSoldar maquina = new MaquinaSoldar("Miller", "ME123X", 500, metales);

        // Personas toman vuelo
        persona1.tomarVuelo("España");
        persona2.tomarVuelo("México");

        System.out.println();

        // Personas juegan con la mascota
        persona1.jugar();
        persona2.jugar();

        System.out.println();

        // Persona intenta soldar dos metales
        persona1.soldar("hierro", maquina);
        persona1.soldar("titanio", maquina);
    }
}