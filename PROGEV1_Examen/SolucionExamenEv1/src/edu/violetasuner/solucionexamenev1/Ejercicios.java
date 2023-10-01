package edu.violetasuner.solucionexamenev1;


import java.util.Scanner;

/**
 * Clase creada para los ejercicios del 1 al 3
 * @author Violeta Suñer
 */
public class Ejercicios {
    
    //Ejercicio 1: normalmente los métodos no leen ni escriben en consola
    //pero se pide escípecíficamenet así en el examen
    //static porque se pide que no se tenga que crear un objeto para llamarlo
    public static double sumar (){
        //Creo un objeto tipo Scanner para leer datos por teclado
        Scanner dato = new Scanner (System.in);
        double numero; //para leer el número
        double resultado = 0; //acumulador, se inicializa a 0 porque vamos a sumar
        //Usamos el bucle do-while para ir leyendo números
        //es un do porque al menos una vez se debe hacer
        //me invento una forma de parar, por ejemplo al introducir un 0
        do {
            System.out.println("Introduce un número (0 para parar):");
            numero = dato.nextDouble();//esto debería ir en un try catch 
                                       //por si no nos escriben un número pero el examen no lo pide
            resultado += numero;//sumar el 0 final no importa porque es 0
        } while (numero!=0); 
        System.out.println("El resultado de la suma es "+resultado);//en lugar de esto...
        return resultado; //...mejor esto
    }
    
    //Ejercicio 2
    public static void escalera (int altura) {
        int piso;//para ir contando el piso de la escalera que estoy escribiendo
        int aster; //para ir contando el número de asteriscos que estoy escribiendo
        
        //empiezo en el piso de "más arriba" y voy bajando
        for (piso=altura; piso>=1; piso--){ //tambien puedo poner piso>0
            //en cada piso hago tantos asteriscos como el piso que estoy
            //4 en el piso 4, 3 en el piso 3,...
            for(aster=1; aster<=piso;aster++){
                System.out.print("*"); //¡ojo! no println que sino salta de línea
                                       //y los quiero seguidos
            }
            //aquí he acabado la línea, salto
            System.out.println();
        }
    }
    
    //Ejercicio 3
    public static void nombre (int opcion, String nombre){
        int blancos=0; //contador de espacios en blanco
        //Con switch se hará una cosa u otra dependiendo de la opcion
        //hay otras formas de buscar los blancos en una cadena, pero este
        //es el que habíais visto
        switch (opcion) {
            case 1: 
                //cuento los espacios
                for(int i=0;i<nombre.length();i++){
                    if(nombre.substring(i, i+1).equals(" ")){
                        blancos++;
                    }
                }
                System.out.println("El número de letras del nombre es "+ (nombre.length()-blancos));
                break;
            case 2: 
                System.out.println("El nombre en mayúsculas es "+ nombre.toUpperCase());
                break;
            case 3: 
                //La primera palabra (el nombre)
                //ojo, que esto fallará si al principio se ha introducido un espacio en blanco
                //habría que limpiar la entrada primero
                String iniciales=nombre.substring(0,1).toUpperCase();
                //Busco los blancos y me quedo con el caracter siguiente
                //A partir del segundo caracter
                for(int i=1;i<nombre.length();i++){
                    if(nombre.substring(i, i+1).equals(" ")){
                        //ojo, que esto fallará si al final se ha introducido un espacio en blanco
                        //habría que limpiar la entrada primero
                        iniciales+=nombre.substring(i+1,i+2).toUpperCase();
                    }
                }
                System.out.println("Las iniciales del nombre son "+ iniciales);
                break;
            default: 
                System.out.println("Opción no válida");
    
        }
    }  
        
}
