package examen_victorvisus;

/**
 *
 * @author Victor Visús
 */
public class Ejercicios {

    public static int ejercicio01(int num01, int num02) {
        int suma = num01 + num02;
        return suma;
    }

    public static void ejercicio02(int altura) {

        int contador;
        for (contador = 1; contador <= altura; contador++) {
//            System.out.println("altura: " + altura + " pisos.");
            var escalon = "*";
            System.out.println(escalon);
        }

    }

    public static void ejercicio03(int numero, String nombre) {

        System.out.println("1. La longitud del nombre es: " + nombre.length());

        System.out.println("2. Nombre en Mayúsculas: " + nombre.toUpperCase());

    }
}
