package tarea2ejercicio10;

/**
 *
 * @author Victor
 */
public class Ejercicio10_operaciones_char {

    public static void main(String[] args) {
        // Operaciones con char //
        System.out.println("\n-- Operaciones con char --");

        char cx = '\u000F', cy = '\u0001';
        System.out.println("Los valores indicados en el ejercicio original para"
                + " las variable cx y cy, son caracteres no imprimibles:");
        System.out.println("cx es de tipo " + ((Object) cx).getClass().getSimpleName() + " y su valor es: " + cx + " no imprimible");
        System.out.println("cy es de tipo " + ((Object) cy).getClass().getSimpleName() + " y su valor es: " + cy + " no imprimible");

        /*
        Declaro los nuevos valores para las variables cx y cy
         */
        cx = '\u0031';//1
        cy = '\u0035';//5

        String tipoCx = ((Object) cx).getClass().getSimpleName();
        String tipoCy = ((Object) cy).getClass().getSimpleName();
        String tipoChar;
        if (tipoCx == tipoCy) {
            tipoChar = "char";
        } else {
            tipoChar = " ";
        }
        System.out.printf("Uso otros valores, los correspondientes a %c (0031) para cx y %c (0035) para cy, ambos de tipo %s\n\n", cx, cy, tipoChar);

        /* A partir de esta linea comienza el ejercicio */
        //Creo la Cadena que formara 15, valor de char cx + cy
        String cad15 = String.valueOf(cx);
        cad15 = cad15 + cy;

        //la convierto a número int para obtener el int 15
        int numCadena = Integer.parseInt(cad15);

        //cojo el valor numérico de cx para operar y obtener la salida indicada
        /*
        char: - = 14
        char(0x000F) - 1 = 14
         */
        int cxInt = Character.getNumericValue(cx);
        System.out.println("char: cx - = " + (numCadena - cxInt));
        System.out.printf("char(0x%04x) - %d = %d\n", numCadena, cxInt, (numCadena - cxInt));

        //la variable z para que la necesito?
        int z = cx - cy;
        //System.out.println("z = " + z);
        //en este punto, y para operar con ella, la variable tiene que ser char o int?
        z = Character.getNumericValue(cx) - 1;
        //System.out.println("z = " + z);

        /*
        ¿Cómo le cambio el valor a una variable tipo char? cx = '\uffff'?
        el caracter correspondiente a este valor creo que no existe, o que es del UTF-16
        ver https://www.fileformat.info/info/unicode/char/ffff/index.htm
        ¿cómo convierto esta variable de UTF-8 a UTF-16?
         */
        cx = '\uffff';
        //System.out.println("cx es de tipo " + ((Object) cx).getClass().getSimpleName() + "y su valor es: " + cx);

        /*
        (int) = 65535
        (short) = -1
         */
        z = cx;
        //System.out.println("z es de tipo " + ((Object) z).getClass().getSimpleName() + " y su valor es: " + z);
        System.out.println("(int) z = cx = " + z);

        short sx = (short) cx;
        //System.out.println("sx es de tipo " + ((Object) sx).getClass().getSimpleName() + " y su valor es: " + sx);
        System.out.println("(short) sx = cx = " + sx);

        /*
        -32768 short-char-int = 32768
         */
        sx -= (short) (cx / 2);
        //System.out.println("sx = " + sx);
        System.out.println(sx + " short-char-int = " + -sx);

        /*
        -1 short-char-int = 65535
         */
        //Algo estoy haciendo mal.
        cx = (char) sx;
        //System.out.println("cx es de tipo " + ((Object) cx).getClass().getSimpleName() + " y su valor es: " + cx);

        z = sx;
        //System.out.println("z es de tipo " + ((Object) z).getClass().getSimpleName() + " y su valor es: " + z);

        sx = -1;
        //System.out.println("sx es de tipo " + ((Object) sx).getClass().getSimpleName() + " y su valor es: " + sx);

        cx = (char) sx;
        //System.out.println("cx es de tipo " + ((Object) cx).getClass().getSimpleName() + " y su valor es: " + cx);

        z = (int) cx;
        //System.out.println("z es de tipo " + ((Object) z).getClass().getSimpleName() + "y su valor es: " + z);

        System.out.println(sx + " short-char-int = " + z);
    }
}
