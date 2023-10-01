/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Victor
 */
public class CtrlInicio implements ActionListener {

    private Inicio appInicio = new Inicio();

    /**
     * Constructor "vacio" de la clase, en el cual se inician las "escuchas" a
     * los botones del panel
     */
    public CtrlInicio() {

        this.appInicio.btnIniciarSesion.addActionListener(this);
        this.appInicio.btnRegistrarse.addActionListener(this);
        this.appInicio.btnSalir.addActionListener(this);
    }

    /**
     * Arranca el panel de inicio
     */
    public void iniciarInicio() {
        appInicio.setVisible(true);

        appInicio.setTitle("Binain");
        appInicio.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appInicio.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }
        //Registrar nuevo usuario
        if (e.getSource() == appInicio.btnRegistrarse) {
            CtrlRegistroUser ctrlReg = new CtrlRegistroUser();

            appInicio.dispose();
            ctrlReg.iniciarRegistro();
        }
        //Iniciar sesión
        if (e.getSource() == appInicio.btnIniciarSesion) {
            CtrlLogin ctrlLogin = new CtrlLogin();

            appInicio.dispose();
            ctrlLogin.iniciarLogin();
        }
    }

}
