package barrantes.jose.bl;

public class Usuario {

    private int id;
    private String nombre;
    private Material[] prestamos;
    private int cantidadPrestamos;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        prestamos = new Material[3];
        cantidadPrestamos = 0;
    }

    public int getId() {
        return id;
    }

    public void prestarMaterial(Material material) throws MaximoPrestamosException {

        if (cantidadPrestamos >= 3) {
            throw new MaximoPrestamosException("El usuario ya tiene 3 préstamos activos.");
        }

        prestamos[cantidadPrestamos] = material;
        cantidadPrestamos++;
    }

    public void devolverMaterial(Material material) {

        for (int i = 0; i < cantidadPrestamos; i++) {

            if (prestamos[i].getId().equals(material.getId())) {

                for (int j = i; j < cantidadPrestamos - 1; j++) {
                    prestamos[j] = prestamos[j + 1];
                }

                prestamos[cantidadPrestamos - 1] = null;
                cantidadPrestamos--;
                break;
            }
        }
    }

    public String toString() {

        String resultado = "\n--USUARIO--";
        resultado += "\nID: " + id;
        resultado += "\nNombre: " + nombre;
        resultado += "\nPrestamos activos: " + cantidadPrestamos;

        return resultado;
    }
}