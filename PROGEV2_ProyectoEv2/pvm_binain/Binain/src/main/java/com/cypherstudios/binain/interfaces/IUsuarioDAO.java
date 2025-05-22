package com.cypherstudios.binain.interfaces;

import com.cypherstudios.binain.modelo.Artista;
import com.cypherstudios.binain.modelo.DatosPersonales;
import com.cypherstudios.binain.modelo.Sala;
import com.cypherstudios.binain.modelo.Usuario;
import java.sql.SQLException;

/**
 * Esta clase establece los métodos que van a gestionar las consultas básicas
 * que puede realizar el usuario sobre la base de datos
 *
 * @author Victor
 */
public interface IUsuarioDAO {

    /**
     * Registra un nuevo usuario en la base de datos
     *
     * @param usr
     * @param user
     * @return
     * @throws java.sql.SQLException
     */
    /*
     ESTE MÉTODO SE PUEDE USAR SIN INICIAR SESIÓN
     */
    public abstract void registrarUser(Usuario usr) throws SQLException;

    public abstract void insertDatosPersonales(Usuario usr) throws SQLException;

    public abstract void insertSala(Sala sala) throws SQLException;

    public abstract void insertArtista(Artista artista) throws SQLException;

    /**
     *
     * @param user : COMPROBAR QUE TIENE QUE RECIBIR
     * @return
     */
    /*
    SE TIENE QUE PODER ACCEDER SIN NECESIDAD
      DE INICIAR SESIÓN */
    public abstract void iniciarSesionSala(Usuario user, Sala sala, DatosPersonales datPerson) throws SQLException;

    public abstract void iniciarSesionArtista(Usuario user, Artista artista, DatosPersonales datPerson) throws SQLException;

    /**
     * Actualiza la información del usuario en la BBDD
     *
     * @param user
     * @return
     */
    public abstract void modificarDatos(Usuario user) throws SQLException;

    ;

    /**
     * Elimina al usuario de la BBDD
     *
     * @param user
     * @return
     */
    public abstract void eliminarUsuario(Usuario user) throws SQLException;
;

}
