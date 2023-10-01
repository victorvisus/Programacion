package tarea2ejercicio5;

import java.util.Scanner;

/**
 *
 * @author Víctor Visús
 * @exceptions EJERCIO 5 de la TAREA 2
 * @descripcion Diseña un programa Java que pida dos números por teclado, determine
 * si el primero es múltiplo del segundo y muestre el resultado.
 */
public class Ejercicio05_Scanner {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Scanner insertNum01 = new Scanner(System.in);
        Scanner insertNum02 = new Scanner(System.in);

        System.out.println("Inserta un numero entero: ");
        float primerNum = insertNum01.nextInt();

        System.out.println("Inserta otro numero entero: ");
        float secondNum = insertNum02.nextInt();

        float resto = primerNum % secondNum;
        float division = primerNum / secondNum;

        if (resto == 0) {
            System.out.println("El primer número es multiplo del segundo");
            System.out.printf("El resto de la división es %.0f y el resultado es un número exacto: %.2f", resto, division);
        } else {
            System.out.println("El primer número no es multiplo del segundo");
            System.out.printf("El resto de la división es %.2f y el resultado no es un número exacto: %.2f", resto, division);
        };
  
    }
}
