package cr.ac.ucenfotec.bl;

/**
Extiende Restaurante, agrega servicio a domicilio y ventanilla.
 */
public class ComidaRapida extends Restaurante {

    private boolean servicioADomicilio;
    private boolean servicioVentanilla;

    public ComidaRapida(String nombre, String ubicacion,
                         boolean servicioADomicilio, boolean servicioVentanilla) {
        super(nombre, ubicacion);
        this.servicioADomicilio = servicioADomicilio;
        this.servicioVentanilla = servicioVentanilla;
    }

    @Override
    public String mostrarTipo() {
        return "Comida Rapida";
    }

    @Override
    public void mostrarInfo() {
        System.out.println(toString());
    }

    public boolean getServicioADomicilio() {
        return servicioADomicilio;
    }

    public boolean getServicioVentanilla() {
        return servicioVentanilla;
    }

    @Override
    public String toString() {
        String domicilio = "No";
        if (servicioADomicilio) {
            domicilio = "Si";
        }
        String ventanilla = "No";
        if (servicioVentanilla) {
            ventanilla = "Si";
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
                + "Ventanilla  : " + ventanilla + "\n"
                + comidas;
    }
}