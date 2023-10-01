package com.cypherstudios.binain.interfaces;

import com.cypherstudios.binain.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IOperacionesUsuario {

    /**
     * Devuelve una lista que contendra los tipos de usuasrio de Sala (si el que
     * hace la llamada es Artista) o Artista (si el que hace la llamada es Sala)
     *
     * @return
     */
    public abstract List<Usuario> listarUsuarios();

    /**
     * Devuelve un objeto de tipo Usuario, dependiendo de donde este
     * implementado el método devolverá un "subtipo" u otro.
     *
     * @return
     */
    public abstract Usuario infoUsuarios();
}
