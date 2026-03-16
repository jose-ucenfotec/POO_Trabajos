package barrantes.jose.bl;

public class Revista extends Material implements Prestable {

    private int numero;

    public Revista(String id, String titulo, int numero) {
        super(id, titulo);
        this.numero = numero;
    }

    public void prestar() throws MaterialNoDisponibleException {

        if (estaPrestado()) {
            throw new MaterialNoDisponibleException("La revista ya está prestada.");
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
        return "\n--REVISTA--" +
                super.toString() +
                "\nNumero: " + numero;
    }
}