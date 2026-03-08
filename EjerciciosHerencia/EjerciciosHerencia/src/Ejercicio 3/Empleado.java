public class Empleado {

    public static final int HORAS_TRABAJADAS_DIA = 8;

    private String nombre;
    private String apellidos;
    private String puesto;
    private double pagoHora;

    public Empleado(String nombre, String apellidos, String puesto, double pagoHora) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.pagoHora = pagoHora;
    }

    public double calcularSalario() {

        int diasSemana = 5;
        int semanasMes = 4;
        int horasMes = HORAS_TRABAJADAS_DIA * diasSemana * semanasMes;

        return horasMes * pagoHora;
    }

    public String toString() {

        return "===== EMPLEADO =====\n" +
                "Nombre: " + nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Puesto: " + puesto + "\n" +
                "Pago por hora: $" + pagoHora + "\n" +
                "Salario mensual: $" + calcularSalario() + "\n";
    }
}