package tarea2ejercicio2;

/**
 * @author Victor
 *
 * EJERCIO 2 de la TAREA 2 Dado el siguiente programa, modifícalo para utilizar
 * las variables que se indican. El tipo de dato elegido debe ser el de menos
 * bits posibles que puedan representar el valor. Justifica tu elección.
 * 
 */
public class Ejercicio02_Variables {

    // Sexo: con dos valores posibles 'V' o 'M'  - char almacena un caracter, pesa 1bit.
    public enum Sexo {
        V, M
        /**
         * Creo que en este caso es mejor hacerlo enumerado por indicar el
         * enunciado que solo tiene dos valores posibles.
         */
    }

    /*
     Para declarar el punto 3. Días de la semana, se podría tambien como un Array.
     Me queda claro que en datos enumerados los valores son constantes y como
     array no -seria un array de Strings-, ¿cual sería el modo más correcto?
     */
    // Día de la semana - Clase Datos enumerados.
    public enum DiasSemanalesEnum {
        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
    };

    public static void main(String[] args) {
        // Días de la semana - Array de String que tiene por valores los dias de la semana.
        String DiasSemanalesArray[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        // Si un empleado está casado o no. - boleano
        boolean empleadoCasado = false;

        /*
        Para esta variable decido que sea de Tipo boolean porque son solo necesarios
        dos valores true o false
         */
        // Valor máximo no modificable: 999999. - constante: int
        final int VALORMAX = 999999;
        /**
         * Para este valor necesitamos el rango de valores que provee el tipo de
         * datos int. Al estar indicado que no puede ser modificable elijo que
         * sea una constante.
         */

        // Día del año. - short
        short diaAnual = 0;
        /**
         * Tipo short tenemos un rango valores más que suficiente para almacenar
         * el número del día del año que necesitemos.
         */

        // Milisegundos transcurridos desde el 01/01/1970 hasta nuestros días. - double
        long miliseg = 0L;
        /**
         * Necesitamos un número entero muy grande por eso el tipo long.
         */

        // Almacenar el total de una factura - float
        float totalFra = 0F;
        /**
         * en este caso necesitamos menos precisión que en el ejemplo anterior
         * y, como le estoy dando su valor por defecto, para que la VM no lo
         * trate como tipo double -que es lo que hace en este caso- y ocupe
         * espacio de más en memoria, le añado la 'F' después del valor de la
         * variable y de ese modo lo entiendo como de tipo float. Otra opción
         * para que no ocurra este podría se no darle valor a la variable: float
         * totalFra;
         */

        // Población mundial del planeta tierra. - long
        long poblacionTotal = 0L;
        /**
         * Para esta variable Tipo númerico muy grande, tipo long. Del mismo
         * modo que el anterior si queremos, que con su valor default, la VM lo
         * trate como este tipo de dato debemos indicarlo con 'L' o 'l' al final
         * del valor. No escojo que sea una constante porque la población de la
         * tierra e variable.
         */

    }

}
