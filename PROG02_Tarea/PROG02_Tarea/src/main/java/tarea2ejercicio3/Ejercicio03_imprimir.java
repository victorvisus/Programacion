package tarea2ejercicio3;

/**
 *
 * @author Victor EJERCIO 3 de la TAREA 2 Realiza las siguientes modificaciones
 * en el programa anterior:
 */
/*
     1. Añade comentarios, entre otros: Nombre de clase, descripción y autor
     Comentario para la clase main y para cada una de las llaves de cierre
 */
/**
 *
 * @author Víctor Visús García
 * @exceptions Ejercicio03_Variables
 * @descripcion Tercer ejercicio de la tarea 2 de Programación
 *
 */
// Clase general
public class Ejercicio03_imprimir { // Apertura clase general

    public enum DiasSemanales {
        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
    };

    public enum Sexo {
        V, M
    }

    // Método principal del programa
    public static void main(String[] args) { // Apertura del metodo principal

        /*
        2. Utiliza el operador de asignación para inicializar las variables a los
        valores que se indican en los mensajes.
         */
        boolean empleadoCasado = true;
        final int VALORMAX = 999999;
        short diaAnual = 300;
        long miliseg = 1298332800000L;
        double totalFra = 10350.678;
        long poblacionTotal = 6775235741L;

        /*
        3. Utiliza la secuencia de escape correspondiente para generar un tabulador
        al principio de cada línea salvo de la primera. ???
        
        4. Mostrar el siguiente resultado:
         */
        String titulo = "-- EJERCICIO DE VARIABLES Y TIPOS DE DATOS --";
        String texto = "El valor de la variable";
        String saltoLinea = "\n";

        // Orden println
        System.out.println(
                titulo + " println");
        System.out.println(
                texto + " casado es: " + empleadoCasado);
        System.out.println(
                "\t" + texto + " MAXIMO es: " + VALORMAX);
        System.out.println(
                "\t" + texto + " diasem es: " + DiasSemanales.Lunes);
        System.out.println(
                "\t" + texto + " diaAnual es: " + diaAnual);
        System.out.println(
                "\t" + texto + " miliseg es: " + miliseg);
        System.out.println(
                "\t" + texto + " totalFra es: " + totalFra);
        System.out.println(
                "\t" + texto + " poblacion es: " + poblacionTotal);
        System.out.println(
                "\t" + texto + " sexo es: " + Sexo.M);

        // Orden print
        System.out.print(titulo + " print"
                + saltoLinea + texto + " casado es: " + empleadoCasado
                + saltoLinea + "\t" + texto + " MAXIMO es: " + VALORMAX
                + saltoLinea + "\t" + texto + " diasem es: " + DiasSemanales.Lunes
                + saltoLinea + "\t" + texto + " diaAnual es: " + diaAnual
                + saltoLinea + "\t" + texto + " miliseg es: " + miliseg
                + saltoLinea + "\t" + texto + " totalFra es: " + totalFra
                + saltoLinea + "\t" + texto + " poblacion es: " + poblacionTotal
                + saltoLinea + "\t" + texto + " sexo es: " + Sexo.M
                + "\n"
        );
        /**
         * La diferencia entre println y print es que la primera no necesita
         * añadir la secuencia de escape de salto de linea si queremos hacer
         * varias lineas.
         */

        // Orden printf
        /**
         * Para dar formato,
         */
        System.out.printf("%s print\n", titulo);
        System.out.printf("%s casado es: %b\n", texto, empleadoCasado);
        System.out.printf("\t%s MAXIMO es: %d\n", texto, VALORMAX);
        System.out.printf("\t%s DiasSemanales es: %s\n", texto, DiasSemanales.Lunes);
        System.out.printf("\t%s diaAnual es: %s\n", texto, diaAnual);
        System.out.printf("\t%s miliseg es: %d\n", texto, miliseg);
        System.out.printf("\t%s totalFra es: %.6f\n", texto, totalFra);
        System.out.printf("\t%s totalFra en notación científica es: %.6e\n", texto, totalFra);
        System.out.printf("\t%s poblacionTotal es: %d\n", texto, poblacionTotal);
        System.out.printf("\t%s sexo es: %s\n", texto, Sexo.M);

        //System.out.printf(texto, args);
    } // Fin del método principal
} // Fin clase general


/*
DUDAS:
1- ¿Cómo podria llamar a la variables declaradas en el ejercicio anterior -en otro
archivo- desde este?
2- Para imprimir texto "auxiliar" como "El valor de la variable" ¿es mejor hacer
un variable String que contenga ese texto o añadir a la orden print como una
cadena de texto? ¿cómo se gestiona en memoria siendo de un modo u de otro?
3- ¿Cómo podría hacer para que me imprimiese el identificador de la variable?
 */
