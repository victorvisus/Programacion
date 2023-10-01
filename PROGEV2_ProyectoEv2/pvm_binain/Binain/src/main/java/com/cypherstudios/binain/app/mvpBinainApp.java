package com.cypherstudios.binain.app;

import com.cypherstudios.binain.controlador.CtrlInicio;
import com.cypherstudios.binain.controlador.CtrlLogin;
import com.cypherstudios.binain.controlador.CtrlRegistroUser;

/**
 *
 * @author Víctor Visús García
 */
public class mvpBinainApp {

    //Controladores
    /**
     * Instancia el controlador que se encarga de las funciones del panel de
     * inicio de la aplicación
     */
    public static CtrlInicio ctrlInicio = new CtrlInicio();

    /* ***************************************** ESTE BLOQUE CREO QUE SOBRA ****/
    /**
     * Instancia el controlador que se encarga de las funciones del panel de
     * inicio de sesión
     */
    public static CtrlLogin ctrlLogin = new CtrlLogin();

    /**
     * Instancia el controlador que se encarga de las funciones del panel de
     * registro de usuario de la aplicación
     */
    public static CtrlRegistroUser ctrlRegistro = new CtrlRegistroUser();

    /* ***************************************** ************************** ****/
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ctrlInicio.iniciarInicio();
    }

}
