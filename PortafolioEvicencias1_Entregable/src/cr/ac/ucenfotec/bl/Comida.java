package cr.ac.ucenfotec.bl;

/**
 * Atributos: nombre, precio, calificacion. Y son privados
 * Pertenece a un restaurante
 */
public class Comida {

    private String nombre;
    private double precio;
    private double calificacion;
    private Restaurante restaurante;

    public Comida(String nombre, double precio, Restaurante restaurante) {
        this.nombre = nombre;
        this.precio = precio;
        this.calificacion = 0.0;
        this.restaurante = restaurante;
    }

    public void calificar(double nota) {
        if (nota < 1.0 || nota > 5.0) {
            System.out.println("La nota debe estar entre 1.0 y 5.0");
            return;
        }
        this.calificacion = nota;
        System.out.println("Calificacion registrada para: " + nombre);
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public boolean estaCalificada() {
        return calificacion > 0.0;
    }

    public void mostrarInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String calif = "sin calificacion";
        if (estaCalificada()) {
            calif = "" + calificacion;
        }
        return "  Nombre : " + nombre + "\n"
             + "  Precio : " + precio + " colones\n"
             + "  Calif  : " + calif + "\n"
             + "  ----------";
    }
}