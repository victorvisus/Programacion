/*
 * Módulo: Programación
 * Ciclo: DAM
 * Examen de la primera evaluación del Programación
 * 
 */
package edu.violetasuner.solucionexamenev1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal
 * @author Violeta Suñer
 * @version 1
 */
public class SolucionExamenEv1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int n;
        //Llamada a los métodos de los ejercicios 1 a 3
        //como son static con el nombre de la clase
        
        //Ejercicio 1: no necesita parámetros
        Ejercicios.sumar();
        //Ejercicio 2: necesita la altura como parámetro
        System.out.println("Introduce la altura de la escalera:");
        n=teclado.nextInt();
        Ejercicios.escalera(n);
        teclado.nextLine();//limpiar el /n que ha dejado el n, 
                           //sino no lee correctamente el nombre
                           //si se lee primero un String y luego un número no hay problema
        //Ejercicio 3
        System.out.println("Dime el nombre: ");
        String nombre=teclado.nextLine();
        System.out.println("Dime la opcion (1 a 3)");                       
        n=teclado.nextInt();
        teclado.nextLine();//limpiar el /n que ha dejado el n, 
                           //por si luego leemos una cadena
        Ejercicios.nombre(n, nombre);
        
        /******************************************
         * Segunda parte, ejercicios 5 en adelante
         ******************************************/
        //Se pide la opción que será válida porque lo ha gestionado el método
        int opcion;
        Producto producto=null; //solo lo declaro, no lo creo, lo pongo a null para poder comprobar luego
        do{
            opcion=menu();
            switch(opcion){
                case 1://Crear producto
                    try{
                        System.out.println("Nombre del producto: ");
                        String nombreProd=teclado.nextLine();
                        System.out.println("Precio del producto: ");
                        double precio=teclado.nextDouble(); //esto puede dar excepción
                        System.out.println("Unidades iniciales del producto: ");
                        int unidades=teclado.nextInt(); //esto puede dar excepción
                        producto=new Producto(nombreProd, precio, unidades);
                    }catch(Exception e){
                        System.out.println("Error al crear el producto");
                    }
                    break;
                case 2: //Comprar unidades
                    if(producto!=null){
                        int cantidad;
                        System.out.println("¿Cuantas unidades quieres comprar? ");
                        cantidad=teclado.nextInt();                                
                        producto.anyadir(cantidad);
                        System.out.println("Añadidas");
                    }else{
                        System.out.println("Tienes que cerar el producto primero");
                    }
                    break;
                case 3: //Vender unidades
                    if(producto!=null){
                        int cantidad;
                        System.out.println("¿Cuantas unidades quieres vender? ");     
                        try{
                            cantidad=teclado.nextInt();                                
                            producto.vender(cantidad);
                            boolean ok=producto.vender(cantidad);
                            if(ok){//una variable booleana no hace falta compararla con nada
                                   //se pone if(ok) o if(!ok)
                                System.out.println("Vendidas");
                            }else{
                                System.out.println("No tenías bastantes");
                            }
                        }catch(InputMismatchException ex){//nextInt puede fallar
                            System.out.println("La cantidad tiene que ser numérica");
                        }
                    }else{
                        System.out.println("Tienes que crear el producto primero");
                    }
                    break;
                case 4: //
                    if(producto!=null){
                        int cantidad;
                        System.out.println("¿Cuantas unidades quieres vender? ");
                        try{
                            cantidad=teclado.nextInt();                                
                            producto.vender2(cantidad);
                        }catch(InputMismatchException ex){//será la del nextInt
                            System.out.println("La cantidad tiene que ser numérica");
                        }catch(Exception ex2){//será la del método, no se puede llamar igual
                            System.out.println(ex2.getMessage());
                        }
                    }else{
                        System.out.println("Tienes que cerar el producto primero");
                    }
                    break;
                case 5: //Mostrar info producto
                    if(producto!=null){
                        System.out.println(producto);//se puede poner producto.toString() pero no es necesario, 
                                                     //se llama automáticamente a este método
                    }else{
                        System.out.println("Tienes que crear el producto primero");
                    }
                    break;
            }
            //no hay que controlar el resto de casos porque 6 es salir 
            //y otros no llegan aquí, lo controla el método menú
        }while(opcion!=6);
        System.out.println("FIN DEL PROGRAMA");
    }
    
    //Ejercicio 7: el método es static para que se pueda llamar desde la main que también es static
    private static int menu(){
        int opcion=-1;
        Scanner teclado=new Scanner(System.in);
        do{
            System.out.println("1- Crear un producto\n" +
                               "2- Comprar productos\n" +
                               "3- Vender productos\n" +
                               "4- Vender productos (versión 2)\n" +
                               "5- Ver información del producto\n" +
                               "6- Salir");
            System.out.print("Introduce opción: ");
            try{
                opcion=teclado.nextInt(); //por si no introduce un número entero
            }catch(Exception e){
                System.out.println("Tienes que escribir un número.");
            }
        }while(opcion<1 || opcion>6);
                             
        return opcion;
    }
    
}
