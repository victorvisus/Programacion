package tarea2ejercicio6;

/**
 *
 * @author Victor Visús
 * @exceptions EJERCIO 6 de la TAREA 2
 * @descripcion Diseña un programa Java que cree un tipo enumerado para los meses del
 * año. El programa debe realizar las siguientes operaciones: 1. Crear una
 * variable m del tipo enumerado y asignarle el mes de marzo. Mostrar por
 * pantalla su valor. Asignar a la variable m, la cadena de texto "MARZO". 2.
 * Mostrar por pantalla el valor de la variable de tipo enumerado tras realizar
 * la asignación.
 */
public class Ejercicio6_enum {

    public enum mesAnual {
        Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Noviembre, Diciembre;
    }

    public static void main(String[] args) {
        System.out.println("Mostrar un valor específico" + mesAnual.Marzo);

        mesAnual m = mesAnual.Marzo;
        // var m = mesAnual.Marzo;
        System.out.println("El valor de la variable 'm' es " + m);

        /* Ejercicio6_enum.mesAnual m;
        m = mesAnual.Marzo;
        System.out.println("El valor de la variable 'm' es "+ m);*/
    }
}
