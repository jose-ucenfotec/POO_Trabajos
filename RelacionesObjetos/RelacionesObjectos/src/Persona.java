public class Persona {

    private String nombre;
    private String apellidos;
    private Pasaporte pasaporte;
    private Mascota mascota;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void sacarPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    public void tomarVuelo(String pais) {

        if (pasaporte != null && pasaporte.getEstaVigente()) {
            System.out.println(nombre + " " + apellidos + " toma un vuelo a " + pais + ".");
        } else {
            System.out.println(nombre + " " + apellidos + " no puede tomar el vuelo, ya que su pasaporte no está vigente.");
        }
    }

    public void adoptarMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void jugar() {

        if (mascota != null) {
            System.out.println(nombre + " " + apellidos + " juega con su mascota " + mascota.getNombre() + ".");
        }
    }

    public void soldar(String metal, MaquinaSoldar maquina) {
        maquina.soldar(metal);
    }
}