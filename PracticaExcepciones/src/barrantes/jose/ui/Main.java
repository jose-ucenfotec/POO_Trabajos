package barrantes.jose.ui;

import barrantes.jose.bl.*;

public class Main {

    private static java.io.BufferedReader entrada =
            new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        boolean salir = false;

        while (!salir) {

            try {

                mostrarMenu();
                String opcion = entrada.readLine();

                switch (opcion) {

                    case "1":
                        registrarUsuario(biblioteca);
                        break;

                    case "2":
                        registrarMaterial(biblioteca);
                        break;

                    case "3":
                        prestarMaterial(biblioteca);
                        break;

                    case "4":
                        devolverMaterial(biblioteca);
                        break;

                    case "5":
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {

                System.out.println(e.getMessage());
                RegistroErrores.registrar(e);

            } finally {

                System.out.println("Operación finalizada.");
                System.out.println();
            }
        }
    }

    public static void mostrarMenu() {

        System.out.println("===== BIBLIOTECA =====");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Registrar material");
        System.out.println("3. Prestar material");
        System.out.println("4. Devolver material");
        System.out.println("5. Salir");
        System.out.print("Seleccione opción: ");
    }

    public static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);
                return Integer.parseInt(entrada.readLine());

            } catch (NumberFormatException e) {

                System.out.println("Debe ingresar un número válido.");

            } catch (Exception e) {

                System.out.println("Error leyendo el dato.");
            }
        }
    }

    public static void registrarUsuario(Biblioteca biblioteca) throws Exception {

        int id = leerEntero("ID usuario: ");

        System.out.print("Nombre usuario: ");
        String nombre = entrada.readLine();

        biblioteca.registrarUsuario(new Usuario(id, nombre));

        System.out.println("Usuario registrado correctamente.");
    }

    public static void registrarMaterial(Biblioteca biblioteca) throws Exception {

        System.out.println("1. Libro");
        System.out.println("2. Revista");

        String tipo = entrada.readLine();

        if (tipo.equals("1")) {

            System.out.print("ID: ");
            String id = entrada.readLine();

            System.out.print("Titulo: ");
            String titulo = entrada.readLine();

            System.out.print("Autor: ");
            String autor = entrada.readLine();

            System.out.print("ISBN: ");
            String isbn = entrada.readLine();

            biblioteca.registrarMaterial(new Libro(id, titulo, autor, isbn));

            System.out.println("Libro registrado.");

        } else if (tipo.equals("2")) {

            System.out.print("ID: ");
            String id = entrada.readLine();

            System.out.print("Titulo: ");
            String titulo = entrada.readLine();

            int numero = leerEntero("Numero: ");

            biblioteca.registrarMaterial(new Revista(id, titulo, numero));

            System.out.println("Revista registrada.");

        } else {

            System.out.println("Tipo inválido.");
        }
    }

    public static void prestarMaterial(Biblioteca biblioteca) {

        try {

            int usuarioId = leerEntero("ID usuario: ");

            System.out.print("ID material: ");
            String materialId = entrada.readLine();

            biblioteca.prestarMaterial(usuarioId, materialId);

            System.out.println("Préstamo realizado.");

        } catch (OperacionBibliotecaException e) {

            System.out.println(e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Detalle: " + e.getCause().getMessage());
            }

            RegistroErrores.registrar(e);

        } catch (Exception e) {

            RegistroErrores.registrar(e);
        }
    }

    public static void devolverMaterial(Biblioteca biblioteca) {

        try {

            int usuarioId = leerEntero("ID usuario: ");

            System.out.print("ID material: ");
            String materialId = entrada.readLine();

            biblioteca.devolverMaterial(usuarioId, materialId);

            System.out.println("Devolución realizada.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
            RegistroErrores.registrar(e);
        }
    }
}