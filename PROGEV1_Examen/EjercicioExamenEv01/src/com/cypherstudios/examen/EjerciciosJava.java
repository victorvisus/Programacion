package com.cypherstudios.examen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjerciciosJava {

    //Creo la variable (objeto de la clase Scanner) que se usa para recibir los datos introducidos por teclado
    static Scanner teclado = new Scanner(System.in);

    //Declaro un boleano para controlar los bucles de los errores
    static boolean continua = true;

    /**
     * Método para solicitar datos de Texto al usuario
     *
     * @return cadena : Devuelve la cadena de texto introducida por teclado.
     */
    private static String pideTexto() {
        String cadena = null;

        do {
            try {
                /*Limpio el valor null de teclado, por que al inicializar la
                variable lo toma como que ya se ha introducido un valor aceptado */
                teclado.nextLine();

                System.out.println("Introduce un texto: ");
                cadena = teclado.nextLine();

                continua = true;
            } catch (Exception e) {
                System.out.println("Valor introducido no valido");

                teclado.nextLine();
                continua = false;
            }
        } while (continua == false);

        return cadena;
    }

    /**
     * Método para solicitar números decimales al usuario
     *
     * @return numDouble : Devuelve el número introducida por teclado.
     */
    private static double pideNum() {
        double numDouble = 0;

        do {
            try {
                System.out.println("Introduce un número: ");
                numDouble = teclado.nextDouble();
                continua = true;
            } catch (Exception ex) {
                System.out.println("Valor introducido no valido");
                //con teclado.nextLine() borra el contenido de teclado ¿?
                teclado.nextLine();
                continua = false;
            }
        } while (continua == false);

        return numDouble;
    }

    /**
     * 1.Crea un método que se encargue sumar números (piensa que podrían ser 5
     * o 1000) leídos por teclado. El método mostrará el resultado final por
     * pantalla.
     *
     * Llama al método privado
     *
     * @throws java.lang.Exception : Devuelve un error si el valor introducido
     * por teclado no es un número
     */
    public static double sumar() throws Exception {
        double numA = pideNum();
        double numB = pideNum();

        return (numA + numB);
    }

    /**
     * Método que recibe la altura de una escalera de asterístos.Pinta en
     * pantalla una escalera invertida de asteriscos.
     *
     * Llama al método privado pideNum() para solicitar la altura de la escalera
     * y comprobar que el dato introducido es correcto
     *
     * @throws java.lang.Exception :
     */
    public static void escalera() throws Exception {
        int altura = (int) pideNum();
        System.out.println("altura = " + altura + "\n");

        //Repite el bucle mientras que altura sea mayor que 0
        for (int i = altura; i > 0; i--) {
            //Imprime asteríscos en linea mientras z sea mayor que cero, z toma el valor de altura
            for (int z = i; z > 0; z--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    /**
     * Método que recibe un número y el nombre de una persona, dependiendo del
     * número tiene que mostrar:
     *
     * 1.El número de letras del nombre sin contar los espacios en blanco.
     *
     * 2. El nombre en mayúsculas.
     *
     * 3. Las iniciales de cada parte en mayúsculas.
     *
     * En cualquier otro caso mostrará por pantalla "opción no valida"
     *
     * Llama al método pideTexto() para solicitar el nombre. Llama al método
     * pideNum() para solicitar la opción de menú.
     *
     * @throws java.lang.Exception
     */
    public static void nombrePersona() throws Exception {
        String nombre = pideTexto();
        System.out.println("¿Qué quieres hacer con el texto?\n");

        System.out.println("1. Número de letras, sin espacios\n"
                + "2. Nombre en mayusculas\n"
                + "3. Las iniciales de cada parte en mayusculas\n");

        switch ((int) pideNum()) {
            case 1:
                //1. Número de letras, sin espacios
                //String nombreSeg = nombre.replace(" ", "");

                int longitud = nombre.replace(" ", "").trim().length();
                System.out.println("longitud de la cadena (sin espacios) = " + longitud);
                break;
            case 2:
                //2. Nombre en mayusculas
                System.out.println("nombre = " + nombre.toUpperCase());
                break;
            case 3:
                //3. Las iniciales de cada parte en mayusculas
//                System.out.println("Las iniciales del nombre son: "
//                        + nombre.toUpperCase().charAt(0)
//                        + nombre.toUpperCase().charAt(nombre.indexOf(" ") + 1));

                //Declaro una variable char con el contenido de la 1ª posicion del String
                char ini01 = nombre.charAt(0);
                //Lo concateno a un nuevo estring donde se van a almacenar las iniciales de cada palabra
                String iniciales = "" + ini01;

                /* Mediante u bucle for recorro el String introducido para ver si
                cada posición es igual a un espacio en blanco, si es asi cojo esa
                posición + 1 y la concateno al string iniciales. */
                for (int i = 0; i < nombre.length(); i++) {
                    if (nombre.charAt(i) == ' ') {
                        ini01 = nombre.charAt(i + 1);
                        iniciales = iniciales + ini01;
                    }
                }
                System.out.println("Las iniciales del nombre son: " + iniciales.toUpperCase());
                break;

            default:
                System.out.println("Opción no valida");
                break;
        }
    }
}
