package com.cypherstudios.examen;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Víctor Visús
 *
 */
public class EjercicioExamenEv01 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        menuExamen();
    }

    private static void menuExamen() throws Exception {

        System.out.println("¿Qué parte del examen quieres ver?");

        //do {
        System.out.println("1.- Primera parte" + "\n2.- Segunda Parte");
        int opcion;
        try {
            System.out.println("Elige número de opción:");
            opcion = teclado.nextInt();

            switch (opcion) {
                //Crear producto
                case 1:
                    primeraParte();
                    break;
                case 2:
                    //segundaParte();
                    AppProducto.appProducto();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } catch (Exception msg) {
            System.out.println("Debes introducir una de las dos opciones indicadas, en valor numérico");
        }
        //} while (Producto.opcionMenu() != 3);
    }

    private static void primeraParte() throws Exception {
        System.out.println("\n/*** EJERCICIO 1 - Sumar dos números ***/\n");
        System.out.println("La suma de los número introducidos es " + EjerciciosJava.sumar());

        System.out.println("\n/*** EJERCICIO 2 - Pintar escalera ***/\n");
        EjerciciosJava.escalera();

        System.out.println("\n/*** EJERCICIO 3 - Operaciones String ***/\n");
        EjerciciosJava.nombrePersona();
    }
}
