public class Mascota {

    private String identificador;
    private String nombre;
    private String especie;
    private boolean estado;
    private DispositivoLocalizacion dispositivoAsociado;

    public Mascota(String identificador, String nombre, String especie) {

        this.identificador = identificador;
        this.nombre = nombre;
        this.especie = especie;
        this.estado = false;
        this.dispositivoAsociado = null;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public DispositivoLocalizacion getDispositivoAsociado() {
        return dispositivoAsociado;
    }

    public void setDispositivoAsociado(DispositivoLocalizacion dispositivoAsociado) {
        if (this.dispositivoAsociado == null) {
            this.dispositivoAsociado = dispositivoAsociado;
        }
    }

    public String toString() {

        String estadoTexto;

        if (estado) {
            estadoTexto = "Perdido";
        } else {
            estadoTexto = "No perdido";
        }

        if (dispositivoAsociado != null) {

            return "MASCOTA\n" +
                    "ID: " + identificador + "\n" +
                    "Nombre: " + nombre + "\n" +
                    "Especie: " + especie + "\n" +
                    "Estado: " + estadoTexto + "\n" +
                    dispositivoAsociado.toString();
        }

        return "MASCOTA\n" +
                "ID: " + identificador + "\n" +
                "Nombre: " + nombre + "\n" +
                "Especie: " + especie + "\n" +
                "Estado: " + estadoTexto + "\n" +
                "Sin dispositivo asociado.\n";
    }
}