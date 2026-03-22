package cr.ac.ucenfotec.bl;

/**
 * El catalogo de restaurantes. Esta clase TIENE los distintos restaurantes que los usuarios agreguen.
 */
public class Catalogo {

    public static final int MAX_RESTAURANTES = 30;

    private String nombre;
    private Restaurante[] restaurantes;
    private int total;

    public Catalogo(String nombre) {
        this.nombre = nombre;
        this.restaurantes = new Restaurante[MAX_RESTAURANTES];
        this.total = 0;
    }

    public boolean agregarRestaurante(Restaurante r) {
        if (total >= MAX_RESTAURANTES) {
            System.out.println("Catalogo lleno.");
            return false;
        }
        restaurantes[total] = r;
        total = total + 1;
        return true;
    }

    public Restaurante buscarPorNombre(String nombre) {
        for (int i = 0; i < total; i++) {
            if (restaurantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return restaurantes[i];
            }
        }
        return null;
    }

    public Restaurante getRestaurante(int indice) {
        if (indice >= 0 && indice < total) {
            return restaurantes[indice];
        }
        return null;
    }

    public int getTotal() {
        return total;
    }

    public String getNombre() {
        return nombre;
    }
}
