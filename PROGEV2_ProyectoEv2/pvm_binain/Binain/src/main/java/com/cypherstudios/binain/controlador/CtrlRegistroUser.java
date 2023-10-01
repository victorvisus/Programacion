package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.app.mvpBinainApp;
import com.cypherstudios.binain.modelo.*;
import com.cypherstudios.binain.util.*;
import com.cypherstudios.binain.exception.BinainException;
import com.cypherstudios.binain.vista.PanelRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CtrlRegistroUser implements ActionListener {

    //Objetos
    private Usuario usr;
    private DatosPersonales datPerson;
    private Sala sala;
    private Artista artista;
    //Operaciones DAO
    private UsuarioDAO userDao = new UsuarioDAO();

    //Vista
    private PanelRegistro appRegistro = new PanelRegistro();

    //Inicio
    //CtrlInicio ctrlInicio = new CtrlInicio();
    public CtrlRegistroUser() {

        this.appRegistro.btnRegistrar.addActionListener(this);
        this.appRegistro.btnVolver.addActionListener(this);
        this.appRegistro.btnSalir.addActionListener(this);
    }

    public void iniciarRegistro() {
        appRegistro.setVisible(true);

        appRegistro.setTitle("Registro de nuevo usuario");
        appRegistro.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == appRegistro.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }
        if (e.getSource() == appRegistro.btnVolver) {
            appRegistro.dispose();
            mvpBinainApp.ctrlInicio.iniciarInicio();

        }

        if (e.getSource() == appRegistro.btnRegistrar) {
            btnRegistrar();
        }

    }

    private void btnRegistrar() {

        //Crea el objeto datos peersonales para pasarselo al usuario
        datPerson = new DatosPersonales();
        datPerson.setNombre(appRegistro.txtNombre.getText());
        datPerson.setApellido(appRegistro.txtApellido.getText());
        datPerson.setDireccion(appRegistro.txtDireccion.getText());
        datPerson.setLocalidad(appRegistro.txtLocalidad.getText());

        try {
            validaForm();

            //Encripto la constraseña
            String pass = new String(appRegistro.txtPassword.getPassword());
            String passwordHash = Hash.sha1(pass);

            //Evaluo Si el usuario es Artista o Sala
            usr = new Usuario();
            if (appRegistro.rbtnArtista.isSelected()) {
                artista = new Artista();

                artista.setNickName(appRegistro.txtNickName.getText());
                artista.setEmail(appRegistro.txtEmail.getText());
                artista.setPassword(passwordHash);
                artista.setIdTipoUsr(2);
                artista.setNombreArtista(appRegistro.txtNombreArtista.getText());

                artista.setDatosPersonales(datPerson);

                //Compruebo que el usuario no existe en la BBDD
                userDao.existeUsuario(artista);
                userDao.existeMail(artista);

                userDao.registrarUser(artista);
                userDao.insertArtista(artista);
            } else if (appRegistro.rbtnSala.isSelected()) {
                sala = new Sala();

                sala.setNickName(appRegistro.txtNickName.getText());
                sala.setEmail(appRegistro.txtEmail.getText());
                sala.setPassword(passwordHash);
                sala.setIdTipoUsr(1);
                sala.setNombreSala(appRegistro.txtNombreSala.getText());

                sala.setDatosPersonales(datPerson);

                //Compruebo que el usuario no existe en la BBDD
                userDao.existeUsuario(sala);
                userDao.existeMail(sala);

                userDao.registrarUser(sala);
                userDao.insertSala(sala);
            }

            JOptionPane.showMessageDialog(null, "Usuario Registrado", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

            limpiaForm();

            appRegistro.dispose();
            mvpBinainApp.ctrlLogin.iniciarLogin();
        } catch (BinainException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Registro de Usuario", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            System.out.println("Código de Error: " + ex.getErrorCode() + "\n"
                    + "SLQState: " + ex.getSQLState() + "\n"
                    + "Mensaje: " + ex.getMessage() + "\n");

            if (ex.getErrorCode() == 1062) {
                //Recoge el error lanzado por la base de datos por duplicar campos UNIQUE
                JOptionPane.showMessageDialog(null, "El nombre de usuario o el e-mail ya existe", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el usuario", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
            }
            //Si salta una SQLException, limpiara todo rastro del usuario que se haya intentado registrar
            userDao.deleteError();
        }

    }

    /**
     * Valida el formulario de registro. Llama a los distintos métodos y les
     * pasa los datos necesarios para cada una de las validaciones
     *
     * Para validar campos duplicados recogo el error que lanza la BBDD, esta
     * operación se encuentra en el bloque try/catch del método de control
     *
     * @throws BinainException : lanza un mensaje dependiendo del tipo de error
     */
    private void validaForm() throws BinainException {

        String pass = new String(appRegistro.txtPassword.getPassword());
        String passConf = new String(appRegistro.txtPasswordConf.getPassword());

        //Validaciones
        validaciones.valCorreo(appRegistro.txtEmail.getText());
        validaciones.valPassword(pass, passConf);
        validaciones.valTipoUser(appRegistro.rbtnArtista, appRegistro.rbtnSala);

        //Validar los campos que no pueden estar vacios
        ArrayList<JTextField> campos = new ArrayList<>();
        campos.add(appRegistro.txtNickName);
        campos.add(appRegistro.txtLocalidad);
        if (appRegistro.rbtnArtista.isSelected()) {
            campos.add(appRegistro.txtNombreArtista);
        } else if (appRegistro.rbtnSala.isSelected()) {
            campos.add(appRegistro.txtNombreSala);
        }
        validaciones.valCamposNull(campos);
    }

    private void limpiaForm() {
        appRegistro.txtNickName.setText(null);
        appRegistro.txtEmail.setText(null);
        appRegistro.txtPassword.setText(null);
        appRegistro.txtPasswordConf.setText(null);

        appRegistro.txtNombre.setText(null);
        appRegistro.txtApellido.setText(null);
        appRegistro.txtDireccion.setText(null);
        appRegistro.txtLocalidad.setText(null);

        appRegistro.rbtnArtista.setSelected(false);
        appRegistro.rbtnSala.setSelected(false);
    }
}
