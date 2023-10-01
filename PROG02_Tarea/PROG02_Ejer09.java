package tarea2ejercicio9;

import java.util.Scanner;

/**
 *
 * @author Victor Visús
 * @exceptions EJERCIO 9 de la TAREA 2
 * @descripcion Diseña un programa Java que solicite un número de 5 dígitos del
 * teclado, separe el número en sus dígitos individuales y los muestre por
 * pantalla. Por ejemplo, si el número es 53123 que muestre:
 *
 * 5 3 1 2 3
 */
public class Ejercicio9_cadenas {

    public static void main(String[] args) {

        Scanner numero = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        long x = numero.nextLong();

        var numCadena = String.valueOf(x);
        System.out.println("numCadena = " + numCadena);

//        System.out.print(numCadena.substring(0,1));
//        System.out.print(numCadena.substring(1,2));
        for (int i = 0; i < numCadena.length(); i++) {
            //System.out.print(numCadena.charAt(i) + " ");
            System.out.printf("%s\s", numCadena.charAt(i));
        }
    }
}
