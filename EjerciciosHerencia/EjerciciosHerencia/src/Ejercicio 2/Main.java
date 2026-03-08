public class Main {

    private static java.io.BufferedReader entrada =
            new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    public static void main(String[] args) throws java.io.IOException {

        System.out.println("Seleccione la figura:");
        System.out.println("1) Rectangulo");
        System.out.println("2) Circulo");
        System.out.print("Opcion: ");

        String opcion = entrada.readLine();

        if (opcion.equals("1")) {

            System.out.print("Ingrese base: ");
            double base = Double.parseDouble(entrada.readLine());

            System.out.print("Ingrese altura: ");
            double altura = Double.parseDouble(entrada.readLine());

            Rectangulo rectangulo = new Rectangulo(base, altura);

            System.out.println("Area: " + rectangulo.calcularArea());
            System.out.println("Perimetro: " + rectangulo.calcularPerimetro());
        }

        if (opcion.equals("2")) {

            System.out.print("Ingrese radio: ");
            double radio = Double.parseDouble(entrada.readLine());

            Circulo circulo = new Circulo(radio);

            System.out.println("Area: " + circulo.calcularArea());
            System.out.println("Perimetro: " + circulo.calcularPerimetro());
        }
    }
}