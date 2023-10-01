/*
 * tiposenumerados.java
 * Ejemplo de Tipos enumerados
 */

/**
 *
 * @author FMA
 */
public class tiposenumerados {
    public enum Dias {Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo};
    
    public static void main(String[] args) {
        // codigo de la aplicacion
        Dias diaactual = Dias.Martes;
        Dias diasiguiente = Dias.Miercoles;
        
        System.out.print("Hoy es: ");
        System.out.println(diaactual);
        System.out.println("Mañana\nes\n"+diasiguiente);    
    
    } // fin main

} // fin tiposenumerados
