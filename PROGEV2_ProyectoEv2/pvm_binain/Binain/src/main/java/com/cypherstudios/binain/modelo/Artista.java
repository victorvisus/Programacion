package com.cypherstudios.binain.modelo;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Artista extends Usuario {

    ArrayList<Eventos> eventos;

    private String nombreArtista;

    public Artista() {
        super();
    }

    public Artista(String nickName, String password, String email,
            DatosPersonales datosPersonales, String nombreArtista) {
        super(nickName, password, email, datosPersonales);

        this.nombreArtista = nombreArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    @Override
    public String toString() {
        return super.toString() + "\n - Artista{" + "eventos=" + eventos + ", nombreArtista=" + nombreArtista + '}';
    }


}
