package cr.ac.ucenfotec.bl;

/**
Clase base abstracta para todos los tipos de restaurante.
TIENE Comida[] y Resena[].
 */
public abstract class Restaurante {

    public static final int MAX_COMIDAS = 20;
    public static final int MAX_RESENAS = 10;

    protected String nombre;
    protected String ubicacion;
    protected double calificacion;
    protected Resena[] resenas;
    protected int totalResenas;
    protected Comida[] menu;
    protected int totalComidas;

    public Restaurante(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.calificacion = 0.0;
        this.resenas = new Resena[MAX_RESENAS];
        this.totalResenas = 0;
        this.menu = new Comida[MAX_COMIDAS];
        this.totalComidas = 0;
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

    public void agregarResena(String texto) {
        if (totalResenas >= MAX_RESENAS) {
            System.out.println("Limite de resenas alcanzado.");
            return;
        }
        resenas[totalResenas] = new Resena(texto);
        totalResenas = totalResenas + 1;
    }

    public double getPrecioPromedio() {
        if (totalComidas == 0) return 0;
        double suma = 0;
        for (int i = 0; i < totalComidas; i++) {
            suma = suma + menu[i].getPrecio();
        }
        return suma / totalComidas;
    }

    public String getCosto() {
        double promedio = getPrecioPromedio();
        if (promedio == 0)    return "Sin datos";
        if (promedio < 5000)  return "Bajo";
        if (promedio < 16000) return "Medio";
        return                       "Alto";
    }

    public Comida agregarComida(String nombre, double precio) {
        if (totalComidas >= MAX_COMIDAS) {
            System.out.println("Menu lleno (max " + MAX_COMIDAS + ").");
            return null;
        }
        Comida nueva = new Comida(nombre, precio, this);
        menu[totalComidas] = nueva;
        totalComidas = totalComidas + 1;
        return nueva;
    }

    public Comida buscarComida(String nombre) {
        for (int i = 0; i < totalComidas; i++) {
            if (menu[i].getNombre().equalsIgnoreCase(nombre)) {
                return menu[i];
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getTotalComidas() {
        return totalComidas;
    }

    public int getTotalResenas() {
        return totalResenas;
    }

    public Comida getComida(int i) {
        if (i >= 0 && i < totalComidas) {
            return menu[i];
        }
        return null;
    }

    public Resena getResena(int i) {
        if (i >= 0 && i < totalResenas) {
            return resenas[i];
        }
        return null;
    }

    public abstract String mostrarTipo();

    public void mostrarInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String calif = "sin calificacion";
        if (calificacion > 0) {
            calif = "" + calificacion + " / 5.0";
        }
        String resultado = "\n--" + nombre + " (" + mostrarTipo() + ")--\n"
                + "Ubicacion   : " + ubicacion + "\n"
                + "Calificacion: " + calif + "\n"
                + "Costo       : " + getCosto() + " (prom. " + getPrecioPromedio() + " colones)\n"
                + "Resenas     : " + (totalResenas == 0 ? "sin resenas" : "");
        for (int i = 0; i < totalResenas; i++) {
            resultado = resultado + "\n  " + (i + 1) + ". " + resenas[i].toString();
        }
        return resultado;
    }
}