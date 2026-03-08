public class MaquinaSoldar {

    private String marca;
    private String modelo;
    private int potencia;
    private String[] metalesSoportados;

    public MaquinaSoldar(String marca, String modelo, int potencia, String[] metalesSoportados) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.metalesSoportados = metalesSoportados;
    }

    public void soldar(String metal) {

        boolean puedeSoldar = false;

        for (int i = 0; i < metalesSoportados.length; i++) {
            if (metalesSoportados[i].equals(metal)) {
                puedeSoldar = true;
            }
        }

        if (puedeSoldar) {
            System.out.println("La máquina de soldar " + marca + " " + modelo + " solda el " + metal + ".");
        } else {
            System.out.println("La máquina de soldar " + marca + " " + modelo + " no puede soldar " + metal + ".");
        }
    }
}