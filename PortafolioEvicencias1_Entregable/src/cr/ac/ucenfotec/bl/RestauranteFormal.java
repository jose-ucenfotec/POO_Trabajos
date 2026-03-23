package cr.ac.ucenfotec.bl;

/**
Extiende Restaurante, agrega reservas.
 */
public class RestauranteFormal extends Restaurante {

    private boolean aceptaReservas;

    public RestauranteFormal(String nombre, String ubicacion, boolean aceptaReservas) {
        super(nombre, ubicacion);
        this.aceptaReservas = aceptaReservas;
    }

    @Override
    public String mostrarTipo() {
        return "Formal";
    }

    @Override
    public void mostrarInfo() {
        System.out.println(toString());
    }

    public boolean getAceptaReservas() {
        return aceptaReservas;
    }

    @Override
    public String toString() {
        String reservas = "No";
        if (aceptaReservas) {
            reservas = "Si";
        }
        String comidas = "--Comidas--\n";
        if (totalComidas == 0) {
            comidas = comidas + "Sin comidas registradas.";
        } else {
            for (int i = 0; i < totalComidas; i++) {
                comidas = comidas + menu[i].toString() + "\n";
            }
        }
        return super.toString()
                + "\nReservas    : " + reservas + "\n"
                + comidas;
    }
}