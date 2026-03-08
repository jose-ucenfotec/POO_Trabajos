public class Cliente {

    private String nombre;
    private String apellidos;
    private String cedula;
    private String sexo;
    private String ubicacion;

    public Cliente(String nombre, String apellidos, String cedula, String sexo, String ubicacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.sexo = sexo;
        this.ubicacion = ubicacion;
    }

    public Cliente(String nombre, String apellidos, String cedula, String ubicacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.sexo = "";
        this.ubicacion = ubicacion;
    }

    public Cliente() {
        this.nombre = "";
        this.apellidos = "";
        this.cedula = "";
        this.sexo = "";
        this.ubicacion = "";
    }

    public void suscribirse(Suscripcion suscripcion) {
        System.out.println(getNombreCompleto() + " adquirio una suscripcion " + suscripcion.getTipo() + ".");
    }

    private String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String toString() {

        String sexoTexto;

        if (sexo.equals("")) {
            sexoTexto = "No indicado";
        } else {
            sexoTexto = sexo;
        }

        return "===== CLIENTE =====\n" +
                "Nombre: " + nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Cedula: " + cedula + "\n" +
                "Sexo: " + sexoTexto + "\n" +
                "Ubicacion: " + ubicacion + "\n";
    }
}