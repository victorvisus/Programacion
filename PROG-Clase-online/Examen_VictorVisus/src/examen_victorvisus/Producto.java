package examen_victorvisus;

import java.util.Scanner;
/**
 *
 * @author Victor Visús
 */
public class Producto {

    static Scanner consola = new Scanner(System.in);

    //Atributos
    private String nombre;
    private float precio;
    private int udTienda;

    //Constructor
    public Producto(String nombre, float precio, int udTienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.udTienda = udTienda;
    }

    //metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUdTienda() {
        return udTienda;
    }

    public void setUdTienda(int udTienda) {
        this.udTienda = udTienda;
    }

    /**
     * Método añadir del ejercicio 5 *
     */
    public void comprar() {
        System.out.println("Cuantas unidades añadimos: ");
        int unidades = consola.nextInt();

        int total = unidades + this.udTienda;
        System.out.println("El total de unidades es: " + total);

        setUdTienda(total);
    }

    /**
     * Método vender del ejercicio 5 *
     */
    public void vender() {
        System.out.println("¿Cuántas unidades quieres?");
        int unidades = consola.nextInt();

        int stock = getUdTienda();

        if (unidades <= stock) {
            setUdTienda(stock - unidades);
        } else {
            System.out.println("No hay suficientes unidades");
        }

        System.out.println("Quedan " + getUdTienda() + " unidades");
    }

    public void informacion() {
        System.out.println(
                "nomrbe: " + this.nombre
                + "\nprecio: " + this.precio
                + "\nStock: " + this.udTienda
        );
    }

    public void vender2() throws Exception {
        boolean error = false;
        do {
            try {
                error = false;

                System.out.println("¿Cuántas unidades quieres?");
                int unidades = consola.nextInt();

                int stock = getUdTienda();

                setUdTienda(validaVenta2(unidades, stock));

            } catch (Exception msg) {
                System.out.println(msg);

                error = true;
            }

        } while (error);
    }

    private int validaVenta2(int unidades, int stock) throws Exception {
        int total = 0;
        if (unidades <= stock) {
            total = stock - unidades;

            return total;
        }
        if (unidades >= stock) {
            throw new Exception("No hay tantas unidades en stock");
        }

        return total;
    }

    public void mostrarMenu() {

        System.out.println("1.- Crear un producto"
                + "\n2.- Comprar productos"
                + "\n3.- Vender productos"
                + "\n4.- Vender productos (version2)"
                + "\n5.- Ver información del producto"
                + "\n6.- Salir"
        );

        System.out.println("Elige una opción: ");
        int opcion = consola.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nombre del producto a crear: ");
                String nombre = consola.nextLine();

                System.out.println("Precio: ");
                float precio = consola.nextFloat();

                System.out.println("Cantidad: ");
                int udTienda = consola.nextInt();

                Producto prodcuto01 = new Producto(nombre, precio, udTienda);
                break;

            case 2:
                comprar();
                break;

            case 3:
                vender();
                break;
            case 4:
                break;
            case 5:
                informacion();
                break;
            case 6:
                break;

        }

    }
}
