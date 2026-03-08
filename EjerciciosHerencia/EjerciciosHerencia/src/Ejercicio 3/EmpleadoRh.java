public class EmpleadoRh extends Empleado {

    public EmpleadoRh(String nombre, String apellidos, String puesto, double pagoHora) {
        super(nombre, apellidos, puesto, pagoHora);
    }

    public Empleado contratarEmpleado(String nombre, String apellidos, String puesto, double pagoHora) {

        System.out.println("RH contrata a " + nombre + " " + apellidos +
                " para el puesto de " + puesto + ".");

        return new Empleado(nombre, apellidos, puesto, pagoHora);
    }

    public String toString() {

        return "===== EMPLEADO RH =====\n" +
                super.toString();
    }
}