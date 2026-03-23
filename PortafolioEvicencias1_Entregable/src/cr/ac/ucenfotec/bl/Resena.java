package cr.ac.ucenfotec.bl;

/**
No existe fuera del restaurante que lo contiene
 */
public class Resena {

    private String texto;

    public Resena(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}