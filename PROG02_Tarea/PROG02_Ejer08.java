package tarea2ejercicio8;

//import java.lang.System;
import java.util.Scanner;

/**
 *
 * @author Victor Visús
 * @exceptions EJERCIO 8 de la TAREA 2
 * @descripcion Diseña un programa Java que calcule la suma, resta, multiplicación y
 * división de dos números introducidos por teclado. Incorpora también las
 * funciones que permitan realizar la potencia de un número y la raíz cuadrada
 * del otro.
 *
 * Salida del programa para x=9, y=3: Introducir primer numero: 9 Introducir
 * segundo numero: 3 x = 9.0 y = 3.0 x + y = 12.0 x - y = 6.0 x * y = 27.0 x / y
 * = 3.0 x ^ 2 = 81.0 √ x = 3.0
 */
public class Ejercicio8_operadores02 {

    public static void main(String[] args) {
        Scanner num01 = new Scanner(System.in);
        Scanner num02 = new Scanner(System.in);

        System.out.println("Introduce un primer número: ");
        //float x = num01.nextInt();
        float x = num01.nextFloat();

        System.out.println("Introduce otro para jugar: ");
        float y = num02.nextFloat();

        System.out.printf("Los número introducidos son %.0f, para el primer valor, y %.0f para el segundo.\nComencemos!\n", x, y);

        System.out.printf("x = %.1f y = %.1f\n", x, y);
        System.out.printf("x + y = %.1f\n", (x + y));
        System.out.printf("x - y = %.1f\n", (x - y));
        System.out.printf("x * y = %.1f\n", (x * y));
        System.out.printf("x / y = %.1f\n", (x / y));

        var potencia = Math.pow(x, 2);
        System.out.printf("x ^ 2 = %.1f\n", potencia);

        var raiz = Math.sqrt(x);
        //char simbolo = '\u221A';
        //System.out.println(simbolo + raiz);
        System.out.printf("raiz x = %.1f\n", raiz);
        System.out.println("¿cómo hago para imprimir el carácter de la raiz cuadrada?"
                + " usando un tipo char con el Unicode no funciona");


    }

}
