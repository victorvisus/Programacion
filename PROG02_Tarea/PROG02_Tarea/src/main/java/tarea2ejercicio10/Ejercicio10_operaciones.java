package tarea2ejercicio10;

/**
 *
 * @author Victor Visús
 * @exceptions EJERCIO 10 de la TAREA 2
 * @descripcion Diseña un programa Java que realice las siguientes operaciones,
 * en el orden que se muestran. Se indica la variable y el tipo de dato que
 * recibe el valor o resultado de la operación indicada:
 *
 */
public class Ejercicio10_operaciones {

    public static void main(String[] args) {

        // Conversiones entre enteros y coma flotante //
        float x = 4.5f, y = 3.0f;
        int i = 2, j = (i * Math.round(x));
        //float jf = (i * x);
        double dx = 2.0, dz = (dx * y);

        System.out.println("\n-- Conversiones entre enteros y coma flotante --");

        System.out.println("\nProducto de int por float: jf = i * x = " + (i * x));
//        System.out.println("Nota: el resultado anterior es mediante conversión automática"
//                + " inicializando j como float, no como int como indica el ejercicio");
//        System.out.println("\nProducto de int por float:  j= i*x = " + j);
//        System.out.println("Nota: este resultado es declarando la operación,"
//                + " tal y como indica el ejercicio, como int y convirtiendo x, mediante"
//                + " conversión explícita, de float a int");
        System.out.println("Producto de float por double: dz = dx * y = " + dz);

        // Operaciones con byte //
        System.out.println("\n-- Operaciones con byte --");
        byte bx = 5, by = 2;
        var bz = (bx - by);
        System.out.println("\nbyte: " + bx + " - " + by + " = " + bz);

        bx = -128;
        by = 1;
        bz = (byte) (bx - by);
        System.out.println("byte " + bx + " - " + by + " = " + bz);

        bz = (bx - by);
        System.out.println("(int) (-128 - 1) = " + bz);

        // Operaciones con short //
        System.out.println("\n-- Operaciones con short --");
        short sx = 5, sy = 2;
        short sz = (short) (sx - sy);
        System.out.println("short: " + (sx * sy) + " " + -(--sy) + " = " + ((sx * (++sy)) - (sx + sy)));

        sx = 32767;
        sy = 1;
        sz = (short) (sx + sy);
        System.out.println("sx = " + sx);
        System.out.println("sy = " + sy);
        System.out.println("sz = " + sz);
        System.out.println("short " + sx + " + " + sy + " = " + sz);

        // Operaciones con char //
        System.out.println("\n-- Operaciones con char --");

        //char cx = '\u000F', cy = '\u0001';
        System.out.println("Los valores indicados en el ejercicio para las variable cx y cy,\nson caracteres no imprimibles:");
        /*
        Declaro las variables con los nuevos valores
         */
        char cx = '\u0031';//1
        char cy = '\u0035';//5

        String tipoCx = ((Object) cx).getClass().getSimpleName();
        String tipoCy = ((Object) cy).getClass().getSimpleName();
        String tipoChar;
        if (tipoCx == tipoCy) {
            tipoChar = "char";
        } else {
            tipoChar = " ";
        }

        System.out.println("Uso otros valores, los correspondientes a 1 (0031) y 5 (0035):");
        System.out.println("cx = " + cx + "; cy = " + cy + " y ambos son de tipo " + tipoChar);

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
        System.out.println("char: - = " + (numCadena - cxInt));
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
        System.out.println("(int) = " + z);

        sx = (short) cx;// OJO, No declaro el tipo porque este nombre de variable ya esta declarado anteriormente
        System.out.println("(short) = " + sx);

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
