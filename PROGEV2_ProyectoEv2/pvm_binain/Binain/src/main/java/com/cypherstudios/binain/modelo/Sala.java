package com.cypherstudios.binain.modelo;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Sala extends Usuario {

    ArrayList<Eventos> eventos;

    private String nombreSala;

    public Sala() {
        super();
    }

    public Sala(String nickName, String password, String email,
            DatosPersonales datosPersonales, String nombreSala) {
        super(nickName, password, email, datosPersonales);

        this.nombreSala = nombreSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    @Override
    public String toString() {
        return super.toString() + "\n - Sala{" + "eventos=" + eventos + ", nombreSala=" + nombreSala + '}';
    }

}
