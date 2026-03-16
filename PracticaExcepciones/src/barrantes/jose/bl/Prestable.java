package barrantes.jose.bl;

public interface Prestable {

    void prestar() throws MaterialNoDisponibleException;

    void devolver();

    boolean estaPrestado();
}