public class DispositivoLocalizacion {

    private String codigoDispositivo;
    private boolean estado;

    private RegistroUbicacion[] registrosUbicacion;
    private int cantidadRegistros;

    public DispositivoLocalizacion(String codigoDispositivo) {

        this.codigoDispositivo = codigoDispositivo;
        this.estado = true;
        this.registrosUbicacion = new RegistroUbicacion[10];
        this.cantidadRegistros = 0;
    }

    public String getCodigoDispositivo() {
        return codigoDispositivo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public RegistroUbicacion[] getRegistrosUbicacion() {
        return registrosUbicacion;
    }

    public int getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void agregarRegistroUbicacion(RegistroUbicacion registro) {

        if (cantidadRegistros == registrosUbicacion.length) {

            RegistroUbicacion[] nuevo =
                    new RegistroUbicacion[registrosUbicacion.length * 2];

            for (int i = 0; i < registrosUbicacion.length; i++) {
                nuevo[i] = registrosUbicacion[i];
            }

            registrosUbicacion = nuevo;
        }

        registrosUbicacion[cantidadRegistros] = registro;
        cantidadRegistros++;
    }

    public String toString() {

        String estadoTexto;

        if (estado) {
            estadoTexto = "Activo";
        } else {
            estadoTexto = "Inactivo";
        }

        if (cantidadRegistros == 0) {

            return "DISPOSITIVO\n" +
                    "Código: " + codigoDispositivo + "\n" +
                    "Estado: " + estadoTexto + "\n" +
                    "Sin registros de ubicación.\n";
        }

        String registrosTexto = "";

        for (int i = 0; i < cantidadRegistros; i++) {
            registrosTexto = registrosTexto + registrosUbicacion[i].toString();
        }

        return "DISPOSITIVO\n" +
                "Código: " + codigoDispositivo + "\n" +
                "Estado: " + estadoTexto + "\n" +
                "Registros:\n" +
                registrosTexto;
    }
}