package examen_victorvisus;

import java.util.Scanner;
/**
 *
 * @author Victor Visús
 */
public class Examen_VictorVisus {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        /* Ejercicio 1 */
        System.out.println("Escribe un número: ");
        int num01 = consola.nextInt();
        
        System.out.println("Escribe otro número: ");
        int num02 = consola.nextInt();
                
        System.out.println("el resultado es: " + Ejercicios.ejercicio01(num01, num02) );


        /* Ejercicio 2 */
        
        System.out.println("Escribe la altura de la escalera: ");
        int altura = consola.nextInt();
        
        Ejercicios.ejercicio02(altura);
        
        /* Ejercicio 3 */
        System.out.println("Escribe un número: ");
        int numero = consola.nextInt();
        
        consola.nextLine();
        
        System.out.println("Escribe un nombre: ");
        String nombre = consola.nextLine();
        
        Ejercicios.ejercicio03(numero, nombre);
    }

}
