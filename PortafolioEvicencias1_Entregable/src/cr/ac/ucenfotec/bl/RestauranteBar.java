package cr.ac.ucenfotec.bl;

/**
Extiende Restaurante, agrega barra y musica en vivo.
 */
public class RestauranteBar extends Restaurante {

    private boolean tieneBarra;
    private boolean musicaEnVivo;

    public RestauranteBar(String nombre, String ubicacion,
                           boolean tieneBarra, boolean musicaEnVivo) {
        super(nombre, ubicacion);
        this.tieneBarra = tieneBarra;
        this.musicaEnVivo = musicaEnVivo;
    }

    @Override
    public String mostrarTipo() {
        return "Bar";
    }

    @Override
    public void mostrarInfo() {
        System.out.println(toString());
    }

    public boolean getTieneBarra() {
        return tieneBarra;
    }

    public boolean getMusicaEnVivo() {
        return musicaEnVivo;
    }

    @Override
    public String toString() {
        String barra = "No";
        if (tieneBarra) {
            barra = "Si";
        }
        String musica = "No";
        if (musicaEnVivo) {
            musica = "Si";
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
                + "\nBarra       : " + barra + "\n"
                + "Musica vivo : " + musica + "\n"
                + comidas;
    }
}