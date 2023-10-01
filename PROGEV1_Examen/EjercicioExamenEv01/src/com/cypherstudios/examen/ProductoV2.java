package com.cypherstudios.examen;

import java.util.Scanner;

public class ProductoV2 {

    //Creo la variable (objeto de la clase Scanner) que se usa para recibir los datos introducidos por teclado
    static Scanner teclado = new Scanner(System.in);

    static boolean error = true;

    private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor de la Clase Producto v2
     *
     * @param nombre
     * @param precio
     * @param stock
     */
    public ProductoV2(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Métodos Get y Set
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + this.nombre + ", precio=" + this.precio + ", stock=" + this.stock + '}';
    }

    /**
     * Método Añadir unidades al Stock del producto
     *
     * @param addStock : nº de uds. que hay que añadir al Stock del producto
     */
    public void anidir(int addStock) {
        setStock(this.stock + addStock);
    }

    /**
     * Método para Quitar unidades del Stock del producto
     *
     * @param sellStock : nº de uds. a quitar del Stock del producto
     *
     * @throws Exception : Lanza un mensaje si el Stock del producto es inferior
     * al nº de uds. que salen.
     */
    public void vender(int sellStock) throws Exception {

        setStock(this.stock - sellStock);

    }

    /**
     * Muestra por consola la información del producto
     */
    public void info() {
        System.out.println("INFORMACIÓN DE PRODUCTO\n"
                + "Nombre de producto: " + getNombre() + "\n"
                + "Precio unitario: " + getPrecio() + "\n"
                + "Unidades en stock: " + getStock()
        );
    }

    /**
     * Método vender : Realiza una salida de unidades del stock del producto
     * Pregunta cuantas uds. se venden y envía a comprobar si hay stock
     * suficiente, si no ha suficiente lanza un mensaje de indicándolo, vuelve a
     * preguntar hasta que se introduce un valor adecuado
     *
     * @throws Exception : devuelve el error recogido del método
     * comprobarStock(), si no hay suficiente stock. Vuelve a preguntar las
     * unidades a vender
     */
    public void vender02(int sellStock) throws Exception {

        comprobarStock(sellStock);
        setStock(this.stock - sellStock);

    }

    /**
     * Comprueba que hay suficiente Stock para realizar la "venta"
     *
     * @param sellStock : recibe un int con la cantidad a vender.
     * @throws Exception : devuelve un error si no hay suficiente stock.
     */
    private void comprobarStock(int sellStock) throws Exception {
        if (sellStock > this.stock) {
            throw new Exception("No hay suficientes unidades en Stock\n"
                    + "Tenemos " + getStock() + " Uds.");
        }
    }
}
