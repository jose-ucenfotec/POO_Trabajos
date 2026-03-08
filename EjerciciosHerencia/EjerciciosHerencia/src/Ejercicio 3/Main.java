public class Main {

    public static void main(String[] args) {

        EmpleadoRh empleadoRh =
                new EmpleadoRh("Ana", "Lopez", "Recursos Humanos", 15);

        Empleado empleado =
                empleadoRh.contratarEmpleado("Luis", "Perez", "Soporte", 10);

        System.out.println();
        System.out.println(empleado);
        System.out.println(empleadoRh);
    }
}