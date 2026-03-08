public class RegistroUbicacion {

    private String identificador;
    private String fechaHora;
    private String direccion;

    public RegistroUbicacion(String identificador, String fechaHora, String direccion) {

        this.identificador = identificador;
        this.fechaHora = fechaHora;
        this.direccion = direccion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getDireccion() {
        return direccion;
    }

    public String toString() {

        return "ID Registro: " + identificador +
                " | FechaHora: " + fechaHora +
                " | Dirección: " + direccion + "\n";
    }
}