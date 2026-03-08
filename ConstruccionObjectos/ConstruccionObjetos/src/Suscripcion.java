public class Suscripcion {

    private String tipo;
    private double costo;
    private int periodicidadMeses;

    public Suscripcion(String tipo, double costo, int periodicidadMeses) {
        this.tipo = tipo;
        this.costo = costo;
        this.periodicidadMeses = periodicidadMeses;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getPeriodicidadMeses() {
        return periodicidadMeses;
    }

    public void setPeriodicidadMeses(int periodicidadMeses) {
        this.periodicidadMeses = periodicidadMeses;
    }

    public String toString() {
        return "===== SUSCRIPCION =====\n" +
                "Tipo: " + tipo + "\n" +
                "Costo: " + costo + "\n" +
                "Periodicidad (meses): " + periodicidadMeses + "\n";
    }
}