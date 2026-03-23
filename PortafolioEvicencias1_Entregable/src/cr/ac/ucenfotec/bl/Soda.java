package cr.ac.ucenfotec.bl;

/**
Extiende Restaurante, agrega servicio a domicilio.
 */
public class Soda extends Restaurante {

    private boolean servicioADomicilio;

    public Soda(String nombre, String ubicacion, boolean servicioADomicilio) {
        super(nombre, ubicacion);
        this.servicioADomicilio = servicioADomicilio;
    }

    @Override
    public String mostrarTipo() {
        return "Soda";
    }

    @Override
    public void mostrarInfo() {
        System.out.println(toString());
    }

    public boolean getServicioADomicilio() {
        return servicioADomicilio;
    }

    @Override
    public String toString() {
        String domicilio = "No";
        if (servicioADomicilio) {
            domicilio = "Si";
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
                + "\nDomicilio   : " + domicilio + "\n"
                + comidas;
    }
}