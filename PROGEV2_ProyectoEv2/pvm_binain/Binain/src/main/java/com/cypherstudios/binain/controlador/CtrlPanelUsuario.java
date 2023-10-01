package com.cypherstudios.binain.controlador;

import com.cypherstudios.binain.app.mvpBinainApp;
import com.cypherstudios.binain.modelo.Artista;
import com.cypherstudios.binain.modelo.Sala;
import com.cypherstudios.binain.modelo.Usuario;
import com.cypherstudios.binain.modelo.UsuarioDAO;
import com.cypherstudios.binain.vista.PanelUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CtrlPanelUsuario implements ActionListener {

    //Objetos
    private Usuario user;
    private Sala sala;
    private Artista artista;

    //Operaciones DAO
    private UsuarioDAO userDao = new UsuarioDAO();

    //Vista
    private PanelUsuario appPanUsuario;

    //Constructores
    public CtrlPanelUsuario(Sala sala) {
        this.sala = sala;

        this.appPanUsuario = new PanelUsuario(this.sala);
        this.botones();

    }

    public CtrlPanelUsuario(Artista artista) {
        this.artista = artista;

        this.appPanUsuario = new PanelUsuario(this.artista);
        this.botones();
    }

    public void botones() {
        this.appPanUsuario.btnSalir.addActionListener(this);
        this.appPanUsuario.btnImprimeUsr.addActionListener(this);

//        this.appPanUsuario.menuArtista.addActionListener(this);
//        this.appPanUsuario.menuSala.addActionListener(this);
//        this.appPanUsuario.menuVerCuenta.addActionListener(this);
        this.appPanUsuario.btnActualizarUsuario.addActionListener(this);
        this.appPanUsuario.btnEliminarUsuario.addActionListener(this);

    }

    public void iniciarPanelUsuarioSalas() {
        appPanUsuario.setVisible(true);

        appPanUsuario.setTitle("Binain - Panel de Opciones" + " " + sala.getNombreSala());
        appPanUsuario.setLocationRelativeTo(null);

        appPanUsuario.lblNombre.setText(sala.getNickName());
        appPanUsuario.lblRol.setText(sala.getNombre_tipo());
        appPanUsuario.lblNombreMarca.setText(sala.getNombreSala());

        //Datos cuentas
        appPanUsuario.lblMarca.setText("Nombre Sala");
        appPanUsuario.txtNomMarca.setText(sala.getNombreSala());

        appPanUsuario.txtNickUsuario.setText(sala.getNickName());
        appPanUsuario.txtMailUsuario.setText(sala.getEmail());
        //Datos personales
        appPanUsuario.txtNombreUsuario.setText(sala.getDatosPersonales().getNombre());
        appPanUsuario.txtApeUsuario.setText(sala.getDatosPersonales().getApellido());
        appPanUsuario.txtDirUsuario.setText(sala.getDatosPersonales().getDireccion());
        appPanUsuario.txtCiudadUsuario.setText(sala.getDatosPersonales().getLocalidad());

        appPanUsuario.menuArtista.setVisible(false);
    }

    public void iniciarPanelUsuarioArtistas() {
        appPanUsuario.setVisible(true);

        appPanUsuario.setTitle("Binain - Panel de Opciones" + " " + artista.getNombreArtista());
        appPanUsuario.setLocationRelativeTo(null);

        appPanUsuario.lblNombre.setText(artista.getNickName());
        appPanUsuario.lblRol.setText(artista.getNombre_tipo());
        appPanUsuario.lblNombreMarca.setText(artista.getNombreArtista());

        //Datos cuentas
        appPanUsuario.lblMarca.setText("Nombre Artista");
        appPanUsuario.txtNomMarca.setText(artista.getNombreArtista());

        appPanUsuario.txtNickUsuario.setText(artista.getNickName());
        appPanUsuario.txtMailUsuario.setText(artista.getEmail());
        //Datos personales
        appPanUsuario.txtNombreUsuario.setText(artista.getDatosPersonales().getNombre());
        appPanUsuario.txtApeUsuario.setText(artista.getDatosPersonales().getApellido());
        appPanUsuario.txtDirUsuario.setText(artista.getDatosPersonales().getDireccion());
        appPanUsuario.txtCiudadUsuario.setText(artista.getDatosPersonales().getLocalidad());

        appPanUsuario.menuSala.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appPanUsuario.btnSalir) {
            //Cierra la aplicación
            System.exit(0);
        }

        if (e.getSource() == appPanUsuario.btnImprimeUsr) {
            if (sala != null) {
                String datos = "Usuario: " + sala.toString() + "\nUsuario tipo: "
                        + sala.getNombre_tipo() + "\nClase usr: " + sala.getClass();
                JOptionPane.showMessageDialog(null, datos, "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

            } else if (artista != null) {
                String datos = "Usuario: " + artista.toString()
                        + "\nUsuario tipo: " + artista.getNombre_tipo() + "\nClase usr: " + artista.getClass();
                JOptionPane.showMessageDialog(null, datos, "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "No hay usuario logeado", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }

        }
        //** OPERACIONES EN CUENTA **//
        if (e.getSource() == appPanUsuario.btnEliminarUsuario) {

            try {
                if (sala != null) {
                    userDao.eliminarUsuario(sala);
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

                    appPanUsuario.dispose();
                    mvpBinainApp.ctrlInicio.iniciarInicio();
                }
                if (artista != null) {
                    userDao.eliminarUsuario(artista);
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

                    appPanUsuario.dispose();
                    mvpBinainApp.ctrlInicio.iniciarInicio();
                }
            } catch (SQLException ex) {
                System.out.println("Error al eliminar el usuario"
                        + "\nMensaje SQLException: " + ex.getMessage()
                        + "\nCódgio de error: " + ex.getErrorCode());
            }
        }

        if (e.getSource() == appPanUsuario.btnActualizarUsuario) {
            try {
                if (sala != null) {

                    sala.setNickName(appPanUsuario.txtNickUsuario.getText());
                    sala.setEmail(appPanUsuario.txtMailUsuario.getText());
                    //Datos Personales
                    sala.getDatosPersonales().setNombre(appPanUsuario.txtNombreUsuario.getText());
                    sala.getDatosPersonales().setApellido(appPanUsuario.txtApeUsuario.getText());
                    sala.getDatosPersonales().setDireccion(appPanUsuario.txtDirUsuario.getText());
                    sala.getDatosPersonales().setLocalidad(appPanUsuario.txtCiudadUsuario.getText());

                    sala.setNombreSala(appPanUsuario.txtNomMarca.getText());

                    userDao.modificarDatos(sala);
                    JOptionPane.showMessageDialog(null, "Datos Actualizados", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

                    appPanUsuario.lblNombre.setText(sala.getNickName());
                    appPanUsuario.lblRol.setText(sala.getNombre_tipo());
                    appPanUsuario.lblNombreMarca.setText(sala.getNombreSala());
                }
                if (artista != null) {

                    artista.setNickName(appPanUsuario.txtNickUsuario.getText());
                    artista.setEmail(appPanUsuario.txtMailUsuario.getText());
                    //Datos Personales
                    artista.getDatosPersonales().setNombre(appPanUsuario.txtNombreUsuario.getText());
                    artista.getDatosPersonales().setApellido(appPanUsuario.txtApeUsuario.getText());
                    artista.getDatosPersonales().setDireccion(appPanUsuario.txtDirUsuario.getText());
                    artista.getDatosPersonales().setLocalidad(appPanUsuario.txtCiudadUsuario.getText());

                    artista.setNombreArtista(appPanUsuario.txtNomMarca.getText());

                    userDao.modificarDatos(artista);
                    JOptionPane.showMessageDialog(null, "Datos Actualizados", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);

                    appPanUsuario.lblNombre.setText(artista.getNickName());
                    appPanUsuario.lblRol.setText(artista.getNombre_tipo());
                    appPanUsuario.lblNombreMarca.setText(artista.getNombreArtista());
                }
            } catch (SQLException ex) {
                System.out.println("Error al eliminar el usuario"
                        + "\nMensaje SQLException: " + ex.getMessage()
                        + "\nCódgio de error: " + ex.getErrorCode());
            }
        }

    }
}
