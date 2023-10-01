package com.cypherstudios.binain.modelo;

import com.cypherstudios.binain.interfaces.IOperacionesUsuario;
import java.util.List;

/**
 *
 * Clase Usuario, de esta clase heredan las clases Artista y Sala. Implementa a
 * las intefaces IDAOusuario y IOperacionesUsuario
 *
 * @author Victor
 */
public class Usuario extends UsuarioDAO implements IOperacionesUsuario {

    private int idUsuario;
    private int idTipoUsr;

    protected String nickName;
    protected String password;
    protected String email;

    private String nombre_tipo;

    protected DatosPersonales datosPersonales;

    public Usuario() {
    }

    /**
     * Constructor
     *
     * @param nickName
     * @param password
     * @param email
     * @param datosPersonales
     */
    public Usuario(String nickName, String password, String email, DatosPersonales datosPersonales) {
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.datosPersonales = datosPersonales;
    }

    /*
    GETTERS & SETTERS
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoUsr() {
        return idTipoUsr;
    }

    public void setIdTipoUsr(int idTipoUsr) {
        this.idTipoUsr = idTipoUsr;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    //DatosPersonales
    public String getLocalidad() {
        return datosPersonales.getLocalidad();

    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", idTipoUsr=" + idTipoUsr + ", Nombre_tipo=" + nombre_tipo
                + "\n, nickName=" + nickName + ", password=" + password
                + "\n, email=" + email + ", datosPersonales=" + datosPersonales + '}';
    }

    /**
     * Aquí debería ir el Método para almacenar los estilos del usuario en el
     * ArrayList
     *
     * Se tiene que ejecutar cuando se inicie la sesión
     *
     * @return
     *
     */
    //************************************ INTERACCIONES CON OTROS USUARIOS ****//
    @Override
    public List<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario infoUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
