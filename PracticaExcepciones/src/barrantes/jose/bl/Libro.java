package barrantes.jose.bl;

public class Libro extends Material implements Prestable {

    private String autor;
    private String isbn;

    public Libro(String id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    public void prestar() throws MaterialNoDisponibleException {

        if (estaPrestado()) {
            throw new MaterialNoDisponibleException("El libro ya está prestado.");
        }

        setPrestado(true);
    }

    public void devolver() {
        setPrestado(false);
    }

    public boolean estaPrestado() {
        return super.estaPrestado();
    }

    public String toString() {
        return "\n--LIBRO--" +
                super.toString() +
                "\nAutor: " + autor +
                "\nISBN: " + isbn;
    }
}