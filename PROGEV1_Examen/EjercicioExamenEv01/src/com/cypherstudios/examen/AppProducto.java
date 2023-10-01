package com.cypherstudios.examen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppProducto {

    static Scanner teclado = new Scanner(System.in);

//    public static void main(String[] arg) throws InputMismatchException, Exception {
//    }

    public static void appProducto() throws InputMismatchException, Exception {

        ProductoV2 producto01 = null;
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    //Crear producto
                    try {
                        String nomProducto;
                        double precioProducto;
                        int stockProducto;

                        System.out.println("Nombre del Producto: ");
                        nomProducto = teclado.nextLine();

                        System.out.println("Introduce precio: ");
                        precioProducto = teclado.nextDouble();

                        System.out.println("Introduce Stock: ");
                        stockProducto = teclado.nextInt();

                        producto01 = new ProductoV2(nomProducto, precioProducto, stockProducto);

                        System.out.println("Producto " + producto01.getNombre() + " creado.\n");

                        producto01.info();
                    } catch (InputMismatchException msg) {
                        System.out.println("Valor introducido no es válido");

                    teclado.nextLine();
                }
                break;

                case 2:

                    /*
                    ¿cómo podria hacer para que si no existe producto mande a la
                    opcion 1 para crear un producto?
                     */
                    if (producto01 != null) {
                        try {
                            int addStock;

                            System.out.println("Uds. que entran al Stock:");
                            addStock = teclado.nextInt();

                            producto01.anidir(addStock);
                            System.out.println("Unidades añadidas correctamente");
                            System.out.println("Unidades en stock: " + producto01.getStock());
                        } catch (InputMismatchException msg) {
                            System.out.println("El valor introducido debe ser numérico");

                            teclado.nextLine();
                        }
                    } else {
                        System.out.println("No existe ningún producto");
                    }

                    //teclado.nextLine();
                    break;
                case 3:
                    if (producto01 != null) {
                        int delStock;
                        System.out.println("Uds. que salen del Stock");
                        delStock = teclado.nextInt();

                        producto01.vender(delStock);
                        System.out.println("Unidades en stock: " + producto01.getStock());
                    } else {
                        System.out.println("No existe ningún producto");
                    }

                    break;
                case 4:
                    if (producto01 != null) {
                        try {
                            int sellStock;
                            System.out.println("Uds. que salen del Stock");
                            sellStock = teclado.nextInt();

                            producto01.vender02(sellStock);
                            System.out.println("Unidades en stock: " + producto01.getStock());
                        } catch (InputMismatchException msg) {
                            System.out.println("El valor introducido debe ser numérico");
                        } catch (Exception msg2) {
                            System.out.println(msg2.getMessage());
                        }
                    } else {
                        System.out.println("No existe ningún producto");
                    }

                    break;
                case 5:
                    if (producto01 != null) {
                        producto01.info();
                    } else {
                        System.out.println("No existe ningún producto");
                    }
                    break;
            }
        } while (opcion != 6);
    }

    public static int menu() {
        // ¿se inicializa cada vez que vuelve para que limpie el último valor introducido? Me he vuelto loco con esto...
        int opcion = -1;

        do {
            System.out.println(
                    "\n*** MENÚ DE OPERACIONES ***\n"
                    + "1.- Crear producto\n"
                    + "2.- Comprar productos\n"
                    + "3.- Vender productos\n"
                    + "4.- Vender 02 productos\n"
                    + "5.- Ver información del producto\n"
                    + "6.- Salir\n"
            );
            System.out.println("Escoge una opción del menú: ");
            try {
                opcion = teclado.nextInt();

                // Pongo esto para que "limpie el buffer de entrada"
                // ¿No hay otras manera?¿qué hago mal?
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println("Solo se admiten carácteres numéricos");
            }
        } while (opcion < 1 || opcion > 6);

        return opcion;
    }

}
