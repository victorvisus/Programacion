/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.violetasuner.clase05022021;

/**
 *
 * @author cpifp
 */
public class Ejemplos {
    //propiedad de clase, no hay una copia para cada objeto
    //todos comparten esta variable
    public static int instancias;

    public Ejemplos() {
        //instancias se incrementa
        //cada vez que llamamos al constructor con new
        //o sea cada vez que se crea un objeto de este tipo
        instancias++;
        //vaya que cuenta el número de objetos que se van creando de este tipo
    }
     
    public static String lanzarExcepcion(boolean lanzar) throws Exception{
        //Código de la función
        
        //Caso 1: código que puede lanzar una excepción y no hago try-catch
        /*try{
            
        }catch(Exception e){
            //yo no quiero saber nada
            //que se ocupe el método llamante
            throw(e);
        }*/
        
        //Caso 2: la lanzo yo porque quiero, lo suyo es que sea un tipo propio
        if(lanzar){
            Exception ex=new Exception("Excepción lanzada desde el método");
            throw(ex);
            //esta es la mitad del trabajo, 
            //luego hay que capturarlo al llamar a este método
        }
        //aquí solo se llega si no se lanza la excepción3
        return("Todo bien");
       
    }
    
}
