package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.app.mvpBinainApp;
import com.cypherstudios.binain.exception.BinainException;
import com.cypherstudios.binain.modelo.*;
import com.cypherstudios.binain.util.*;
import com.cypherstudios.binain.vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Controla las acciones que se realizan sobre el panel de Login
 *
 * @author Víctor Visús García
 */
public class CtrlLogin implements ActionListener {

    //Objetos
    private Usuario usr;
    private DatosPersonales datPerson;
    public static Sala sala;
    public static Artista artista;
//    private Usuario usr = new Usuario();
//    private DatosPersonales datPerson = new DatosPersonales();
//    public static Sala sala = new Sala();
//    public static Artista artista = new Artista();

    //Operaciones DAO
    private UsuarioDAO userDao = new UsuarioDAO();

    //Vista
    private Login appLogin = new Login();

    public CtrlLogin() {

        this.appLogin.btnAcceder.addActionListener(this);
        this.appLogin.btnRegistro.addActionListener(this);
        this.appLogin.btnSalir.addActionListener(this);
        this.appLogin.btnVolver.addActionListener(this);
    }

    public void iniciarLogin() {
        appLogin.setVisible(true);

        appLogin.setTitle("Inicio de sesión");
        appLogin.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appLogin.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }

        if (e.getSource() == appLogin.btnRegistro) {
            appLogin.dispose();
            mvpBinainApp.ctrlRegistro.iniciarRegistro();
        }

        if (e.getSource() == appLogin.btnVolver) {
            appLogin.dispose();

            appLogin.dispose();
            mvpBinainApp.ctrlInicio.iniciarInicio();
        }

        if (e.getSource() == appLogin.btnAcceder) {
            usr = new Usuario();

            try {
                //Compruebo que los campos no esten vacios
                ArrayList<JTextField> campos = new ArrayList<>();
                campos.add(appLogin.txtUsuario);
                campos.add(appLogin.txtPassword);
                validaciones.valCamposNull(campos);

                String pass = new String(appLogin.txtPassword.getPassword());
                String newPass = Hash.sha1(pass);

                usr.setNickName(appLogin.txtUsuario.getText());
                usr.setPassword(newPass);

                if (userDao.saberTipoUser(usr).equals("Sala")) {
                    sala = new Sala();
                    userDao.iniciarSesionSala(usr, sala, datPerson);

                    CtrlPanelUsuario ctrlPanelUsuario = new CtrlPanelUsuario(sala);
                    ctrlPanelUsuario.iniciarPanelUsuarioSalas();
                    appLogin.dispose();

                } else if (userDao.saberTipoUser(usr).equals("Artista")) {
                    artista = new Artista();
                    userDao.iniciarSesionArtista(usr, artista, datPerson);

                    CtrlPanelUsuario ctrlPanelUsuario = new CtrlPanelUsuario(artista);
                    ctrlPanelUsuario.iniciarPanelUsuarioArtistas();
                    appLogin.dispose();
                } else {
                    //   JOptionPane.showMessageDialog(null, "No hay usuario", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                    throw new BinainException();
                }

//                JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente", "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
//
//                if (sala != null) {
//                    CtrlPanelUsuario ctrlPanelUsuario = new CtrlPanelUsuario(sala);
//                    ctrlPanelUsuario.iniciarPanelUsuarioSalas();
//                    appLogin.dispose();
//                } else if (artista != null) {
//                    CtrlPanelUsuario ctrlPanelUsuario = new CtrlPanelUsuario(artista);
//                    ctrlPanelUsuario.iniciarPanelUsuarioArtistas();
//                    appLogin.dispose();
//                } else {
//                    //JOptionPane.showMessageDialog(null, "No hay usuario logeado", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
//                    throw new BinainException();
//                }

            } catch (BinainException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);

            } catch (SQLException ex) {
                System.out.println("Código de Error: " + ex.getErrorCode() + "\n"
                        + "SLQState: " + ex.getSQLState() + "\n"
                        + "Mensaje: " + ex.getMessage() + "\n");
            }
        }
    }

}
