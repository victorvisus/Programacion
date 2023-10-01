package com.cypherstudios.binain.modelo;

/**
 *
 * @author Victor
 */
public class DatosPersonales {

    private int idDatosPersonales;
    private String nombre;
    private String apellido;
    private String direccion;
    private String localidad;

    public DatosPersonales() {
    }

    /**
     * Solo será obligatorio la localidad para crear el usuario
     *
     * @param localidad
     */
    public DatosPersonales(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Para dar más opciones
     *
     * @param nombre
     * @param localidad
     */
    public DatosPersonales(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    /**
     * Constructor completo, el idDatosPersonales lo coge de la base de datos
     *
     * @param nombre
     * @param apellido
     * @param direccion
     * @param localidad
     */
    public DatosPersonales(String nombre, String apellido, String direccion, String localidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
    }

    /*
    GETTERS Y SETTERS
     */
    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(int idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /*
    toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatosPersonales{idDatosPersonales=").append(idDatosPersonales);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", direccion=").append(direccion);
        sb.append(", localidad=").append(localidad);
        sb.append('}');
        return sb.toString();
    }

}
