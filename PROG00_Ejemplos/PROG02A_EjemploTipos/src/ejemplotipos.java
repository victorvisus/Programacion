/*
 * ejemplotipos.java
 * Programa que crea variables de distintos tipos primitivos
 * y los muestra por pantalla
 *
 */
/**
 *
 * @author FMA
 */
public class ejemplotipos {

    // el método main inicia la ejecución de la aplicación
    public static void main(String[] args) {
        // Código de la aplicación
        int i = 10;
        double d = 3.14;
        char c1 = 'a';
        char c2 = 65;
        boolean encontrado = true;
        String msj = "Bienvenido a Java";

        System.out.println("La variable i es de tipo entero y su valor es: " + i);
        System.out.println("La variable f es de tipo double y su valor es: "+d);
        System.out.println("La variable c1 es de tipo carácter y su valor es: "+c1);
        System.out.println("La variable c2 es de tipo carácter y su valor es: "+c2);
        System.out.println("La variable encontrado es de tipo booleano y su valor es: "+encontrado);
        System.out.println("La variable msj es de tipo String y su valor es: " + msj);
    } // fin del método main

} // fin de la clase ejemplotipos
