/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_resuelto_excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author FMA
 */
public class Ejercicio_resuelto_excepciones {

    public static void main(String[] args) {
        int numero = -1;
        int intentos = 0;
        String linea;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                System.out.print("Introduzca un número entre 0 y 100: ");
                linea = teclado.readLine();
                numero = Integer.parseInt(linea);

            } catch (IOException e) {
                System.out.println("Error al leer del teclado.");

            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número entre 0 y 100.");

            } finally {
                intentos++;
            }
        } while (numero < 0 || numero > 100);

        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);

    }

}
