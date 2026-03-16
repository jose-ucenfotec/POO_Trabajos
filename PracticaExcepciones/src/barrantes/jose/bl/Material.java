package barrantes.jose.bl;

public abstract class Material {

    private String id;
    private String titulo;
    private boolean prestado;

    public Material(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public String toString() {
        return "\nID: " + id +
                "\nTitulo: " + titulo +
                "\nPrestado: " + prestado;
    }
}