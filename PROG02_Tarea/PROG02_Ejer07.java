package tarea2ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Victor Visús
 * @exceptions EJERCIO 7 de la TAREA 2
 * @descripcion Diseña un programa Java para resolver una ecuación de primer grado
 * con una incógnita (x), suponiendo que los coeficientes de la ecuación (C1 y
 * C2) se introducen desde teclado.
 *
 * C1x + C2 = 0
 */
public class Ejercicio07_operadores {

    public static void main(String[] args) {

        Scanner scanC1 = new Scanner(System.in);
        Scanner scanC2 = new Scanner(System.in);
        
        System.out.println("La ecuación a resolver es del tipo C1x + C2 = 0");

        System.out.println("Introduce el primer coeficiente de la ecuación: ");
        float c1 = scanC1.nextInt();
        
        System.out.println("Introduce el segundo: ");
        float c2 = scanC2.nextInt();
        
        System.out.println("C1 = " + c1);
        System.out.println("C2 = " + c2);
        
        System.out.printf("%s%.2f%s%.2f%s", "La ecuación queda: ", c1, "x  + ", c2, " = 0" );
        
        var c2neg = c2 * -1;
        System.out.printf("\nDespejamos x: x = %.2f / %.2f", c2neg, c1);
        
        var res = c2neg / c1;
        System.out.printf("\ny resolvemos, el valor de x es %.2f", res);
    }
}
