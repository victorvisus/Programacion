/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violetasuner.clase05022021; //si no se crea por defecto: botón derecho>Refactor>Rename

import com.violetasuner.clase05022021.Ejemplos;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author cpifp
 */
public class Clase05022021 {
    static Scanner teclado;

    static {//bloque static
        teclado=new Scanner(System.in);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         /********************************************
         * Propiedades static o propiedades de clase
         ********************************************/       
        Ejemplos ej1=new Ejemplos();//llamo al constructor
        System.out.println("Desde la clase: "+Ejemplos.instancias);//llamada con la clase porque es static      
        System.out.println("Desde el objeto ej1: "+ej1.instancias);//pero también se puede llamar desde un objeto
        
        Ejemplos ej2=new Ejemplos();//se incrementa en el constructor
        System.out.println("Desde la clase: "+Ejemplos.instancias);
        System.out.println("Desde el objeto ej2: "+ej2.instancias);
        
        Ejemplos ej3=new Ejemplos();
        System.out.println("Desde la clase: "+Ejemplos.instancias);
        System.out.println("Desde el objeto ej3: "+ej3.instancias);
        //no hay una copia para cada objeto ¡es la misma!
        System.out.println("Desde el objeto ej1: "+ej1.instancias);
        System.out.println("Desde el objeto ej2: "+ej2.instancias);
        
        System.out.println("\n\n");

        
        /********************************************
         * Métodos static en la misma clase
         ********************************************/
        int opcion;
        do{
            opcion=menu();
            System.out.println("Has elegido la opción: "+opcion);
        }while(opcion!=0);
                
        /********************************************
         * Controlar la entrada con excepciones
         ********************************************/
        int x;
                
        System.out.println("Introduce un número: ");
        
        //sin controlar la entrada
        //x=teclado.nextInt();
   
        //controlando la entrada
        try{
            x=teclado.nextInt();
        }catch (Exception ex) {
            System.out.println("Error: no es un entero "+ex.getMessage());
            //aquí podemos finalizar ¡ordenadamente!
            System.exit(0);//0 sería todo ok, -1, 1 u otro representaría un tipo de error
        }
        //esto se ejecuta de todos modos aunque haya excepción
        //salvo que se ponga un exit
        System.out.println("Fuera y detras del catch\n\n");
        
        /********************************************
         * Nuestras propias con excepciones
         ********************************************/
        String res;
        try {   
            res=Ejemplos.lanzarExcepcion(false);//esto no dará error
            System.out.println(res+"\n\n");
            res=Ejemplos.lanzarExcepcion(true);//este sí
            //esto ya no se ejecuta porque ha saltado la excepción
            //además res no tiene valor (no cambia de valor)
        } catch (Exception ex) {
            System.out.println("El método ha lanzado la excepción: "+ex.getMessage());
            System.exit(0);
        } 
        
        
    }//fin del main
    
    private static int menu(){
        int opcion;
        teclado=new Scanner(System.in);
                
        System.out.println("1. Lo que sea"); 
        System.out.println("0. Salir");
        System.out.print("Introduce opción: ");
        opcion=teclado.nextInt();//aquí mejor el try-catch
        //deberíamos comprobar que la opción es buena
             
        return opcion;
    }
    
}
