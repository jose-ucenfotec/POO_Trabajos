package barrantes.jose.bl;

public class OperacionBibliotecaException extends BibliotecaException {

    public OperacionBibliotecaException(String mensaje) {
        super(mensaje);
    }

    public OperacionBibliotecaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}