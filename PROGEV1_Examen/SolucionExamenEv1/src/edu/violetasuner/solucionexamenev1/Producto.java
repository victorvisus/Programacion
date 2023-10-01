package edu.violetasuner.solucionexamenev1;

import java.util.Scanner;

/**
 *
 * @author Violeta Suñer
 */
public class Producto {
    //propiedades: privadas por defecto
    private String nombre;
    private double precio;
    private int unidades;

    //constructor con parámetros
    public Producto(String nombre, double precio, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }
    
    //constructor por defecto, solo si voy a querer crear productos sin valores iniciales
    public Producto() {
        //al crear el otro constructor, 
        //este se debe hacer o no podremos crear productos sin valores iniciales
        //si no creáramos el otro constructor este no hace falta, lo crea java
    }

    //métodos accesores o getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        if(unidades>0){ //no deberíamos permitir un producto de stock negativo
            this.unidades = unidades;
        }
    }
    
    public void anyadir(int cantidad)
    {
        this.unidades=this.unidades+cantidad;
    }
    
    //como puede ir algo mal (querer vender más de lo que tengo)
    //devuelvo verdadero o falso según se haya ejecutado con éxito la operación
    //no esobligatorio, podría ser void
    public boolean vender(int cantidad)
    {
        if(unidades-cantidad>=0) //si no hay confusión se puede no usar this
        {
            this.unidades=this.unidades-cantidad;
            return true;
        }
        return false;
    }

    //la manera más adecuada de mostrar info de un objeto es sobreescribir el método toString
    @Override
    public String toString() {
        
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", unidades=" + unidades + '}';
    }
    
   //indico que se puede lanzar una excepción
    public void vender2(int cantidad) throws Exception{
        if(this.unidades-cantidad>=0)
        {
            this.unidades=this.unidades-cantidad;
        }else{
            //la lanzo, solo cuando es necesario
           throw new Exception("No hay suficientes unidades");
        }   
    }
    
}
