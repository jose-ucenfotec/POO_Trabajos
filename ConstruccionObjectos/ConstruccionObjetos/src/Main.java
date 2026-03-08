public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Romario", "Salas Cerdas", "1-1111-1111", "Masculino", "Heredia");
        Cliente cliente2 = new Cliente("Jose", "Barrantes Saenz", "2-2222-2222", "San Jose");
        Cliente cliente3 = new Cliente();

        cliente3.setNombre("Luis");
        cliente3.setApellidos("Perez Mora");
        cliente3.setCedula("3-3333-3333");
        cliente3.setSexo("Masculino");
        cliente3.setUbicacion("Cartago");

        Suscripcion suscripcion1 = new Suscripcion("Premium", 15.99, 1);
        Suscripcion suscripcion2 = new Suscripcion("Duo", 12.99, 1);
        Suscripcion suscripcion3 = new Suscripcion("Estudiante", 7.99, 1);

        // Probar funcionalidad suscribirse()
        cliente1.suscribirse(suscripcion1);
        cliente2.suscribirse(suscripcion2);

        cliente3.suscribirse(new Suscripcion("Mini", 4.99, 1));

        System.out.println();
        System.out.println(cliente1);
        System.out.println(suscripcion3);
    }
}