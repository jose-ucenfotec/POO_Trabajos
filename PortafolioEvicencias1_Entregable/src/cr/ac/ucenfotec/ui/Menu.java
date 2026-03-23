package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Catalogo catalogo = new Catalogo("Tico Food");

    public void mostrarMenu() throws IOException {
        int opcion = -1;
        do {
            System.out.println("\n--Catalogo de Restaurantes--");
            System.out.println("1. Agregar restaurante");
            System.out.println("2. Ver restaurantes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarRestaurante();
                    break;
                case 2:
                    verRestaurantes();
                    break;
                case 0:
                    System.out.println("Nos vemos...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarRestaurante() throws IOException {
        System.out.println("\n--Agregar Restaurante--");
        System.out.println("Tipo de restaurante:");
        System.out.println("1. Formal");
        System.out.println("2. Soda");
        System.out.println("3. Bar");
        System.out.println("4. Comida Rapida");
        System.out.print("Seleccione una opcion: ");
        int tipo = Integer.parseInt(br.readLine());

        if (tipo < 1 || tipo > 4) {
            System.out.println("Tipo invalido. Volviendo al menu.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = br.readLine();

        System.out.print("Ubicacion: ");
        String ubicacion = br.readLine();

        double calificacion = 0;
        boolean calificacionValida = false;
        while (!calificacionValida) {
            System.out.print("Calificacion del restaurante (1.0 - 5.0): ");
            calificacion = Double.parseDouble(br.readLine());
            if (calificacion < 1.0 || calificacion > 5.0) {
                System.out.println("Debe estar entre 1.0 y 5.0. Intente de nuevo.");
            } else {
                calificacionValida = true;
            }
        }

        Restaurante restaurante = null;

        switch (tipo) {
            case 1:
                boolean reservas = false;
                boolean reservasValido = false;
                while (!reservasValido) {
                    System.out.print("Acepta reservas (1. Si / 2. No): ");
                    try {
                        int op = Integer.parseInt(br.readLine());
                        if (op == 1 || op == 2) {
                            reservas = op == 1;
                            reservasValido = true;
                        } else {
                            System.out.println("Ingrese 1 para Si o 2 para No.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese 1 para Si o 2 para No.");
                    }
                }
                restaurante = new RestauranteFormal(nombre, ubicacion, reservas);
                break;
            case 2:
                boolean domicilioSoda = false;
                boolean domicilioSodaValido = false;
                while (!domicilioSodaValido) {
                    System.out.print("Servicio a domicilio (1. Si / 2. No): ");
                    try {
                        int op = Integer.parseInt(br.readLine());
                        if (op == 1 || op == 2) {
                            domicilioSoda = op == 1;
                            domicilioSodaValido = true;
                        } else {
                            System.out.println("Ingrese 1 para Si o 2 para No.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese 1 para Si o 2 para No.");
                    }
                }
                restaurante = new Soda(nombre, ubicacion, domicilioSoda);
                break;
            case 3:
                boolean barra = false;
                boolean barraValido = false;
                while (!barraValido) {
                    System.out.print("Tiene barra (1. Si / 2. No): ");
                    try {
                        int op = Integer.parseInt(br.readLine());
                        if (op == 1 || op == 2) {
                            barra = op == 1;
                            barraValido = true;
                        } else {
                            System.out.println("Ingrese 1 para Si o 2 para No.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese 1 para Si o 2 para No.");
                    }
                }
                boolean musica = false;
                boolean musicaValido = false;
                while (!musicaValido) {
                    System.out.print("Musica en vivo (1. Si / 2. No): ");
                    try {
                        int op = Integer.parseInt(br.readLine());
                        if (op == 1 || op == 2) {
                            musica = op == 1;
                            musicaValido = true;
                        } else {
                            System.out.println("Ingrese 1 para Si o 2 para No.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese 1 para Si o 2 para No.");
                    }
                }
                restaurante = new RestauranteBar(nombre, ubicacion, barra, musica);
                break;
            case 4:
                boolean domicilio = false;
                boolean domicilioValido = false;
                while (!domicilioValido) {
                    System.out.print("Servicio a domicilio (1. Si / 2. No): ");
                    try {
                        int op = Integer.parseInt(br.readLine());
                        if (op == 1 || op == 2) {
                            domicilio = op == 1;
                            domicilioValido = true;
                        } else {
                            System.out.println("Ingrese 1 para Si o 2 para No.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese 1 para Si o 2 para No.");
                    }
                }
                boolean ventanilla = false;
                boolean ventanillaValido = false;
                while (!ventanillaValido) {
                    System.out.print("Servicio desde el carro en ventanilla (1. Si / 2. No): ");
                    try {
                        int op = Integer.parseInt(br.readLine());
                        if (op == 1 || op == 2) {
                            ventanilla = op == 1;
                            ventanillaValido = true;
                        } else {
                            System.out.println("Ingrese 1 para Si o 2 para No.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese 1 para Si o 2 para No.");
                    }
                }
                restaurante = new ComidaRapida(nombre, ubicacion, domicilio, ventanilla);
                break;
        }

        restaurante.calificar(calificacion);

        System.out.println("\n--Agregar Resenas--");
        boolean agregandoResenas = true;
        while (agregandoResenas) {
            System.out.println("\n1. Agregar resena");
            System.out.println("0. Continuar");
            System.out.print("Seleccione una opcion: ");
            int opResena = Integer.parseInt(br.readLine());

            switch (opResena) {
                case 1:
                    System.out.print("Resena: ");
                    String texto = br.readLine();
                    restaurante.agregarResena(texto);
                    System.out.println("Resena agregada.");
                    break;
                case 0:
                    agregandoResenas = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }

        System.out.println("\n--Agregar Comidas--");
        boolean agregandoComidas = true;
        while (agregandoComidas) {
            System.out.println("\n1. Agregar comida");
            System.out.println("0. Terminar y guardar restaurante");
            System.out.print("Seleccione una opcion: ");
            int opComida = Integer.parseInt(br.readLine());

            switch (opComida) {
                case 1:
                    System.out.print("Nombre de la comida: ");
                    String nombreComida = br.readLine();
                    double precio = 0;
                    boolean precioValido = false;
                    while (!precioValido) {
                        System.out.print("Precio (colones): ");
                        precio = Double.parseDouble(br.readLine());
                        if (precio <= 0) {
                            System.out.println("El precio debe ser mayor a cero.");
                        } else {
                            precioValido = true;
                        }
                    }
                    double calComida = 0;
                    boolean calComidaValida = false;
                    while (!calComidaValida) {
                        System.out.print("Calificacion de la comida (1.0 - 5.0): ");
                        calComida = Double.parseDouble(br.readLine());
                        if (calComida < 1.0 || calComida > 5.0) {
                            System.out.println("Debe estar entre 1.0 y 5.0. Intente de nuevo.");
                        } else {
                            calComidaValida = true;
                        }
                    }
                    Comida comida = restaurante.agregarComida(nombreComida, precio);
                    if (comida != null) {
                        comida.calificar(calComida);
                        System.out.println("Comida agregada: " + nombreComida);
                    }
                    break;
                case 0:
                    agregandoComidas = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }

        System.out.println("\n--Resumen del restaurante--");
        restaurante.mostrarInfo();

        System.out.print("\nGuardar restaurante? (1. Si / 2. No): ");
        int confirmar = Integer.parseInt(br.readLine());
        if (confirmar == 1) {
            catalogo.agregarRestaurante(restaurante);
            System.out.println("Restaurante guardado exitosamente.");
        } else {
            System.out.println("Restaurante descartado.");
        }
    }

        private void verRestaurantes() throws IOException {
        if (catalogo.getTotal() == 0) {
            System.out.println("No hay restaurantes registrados.");
            return;
        }

        int opcion = -1;
        do {
            System.out.println(catalogo.toString());
            System.out.println("0. Volver");
            System.out.print("Seleccione un restaurante: ");
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida.");
                continue;
            }

            if (opcion == 0) {
                break;
            }
            Restaurante seleccionado = catalogo.getRestaurante(opcion - 1);
            if (seleccionado == null) {
                System.out.println("Numero invalido. Elija entre 1 y " + catalogo.getTotal());
            } else {
                seleccionado.mostrarInfo();
            }
        } while (opcion != 0);
    }
}