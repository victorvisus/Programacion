package com.cypherstudios.binain.util;

import com.cypherstudios.binain.exception.BinainException;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class validaciones {

    /**
     * Valida que la contraseña elegida cumpla con los requisitos del sistema.
     *
     * Realiza tres validaciones: Comprueba que la contraseña introducida en
     * ambas casillas sean iguales; comprueba que la longitud no sea inferior a
     * 8 caracteres y, por último, que cumple con los estándares de seguridad de
     * la aplicación
     *
     * @param pass : String introducido en el primer campo contraseña del
     * formulario de registro
     * @param passConf : String contraseña necesario para comprobar que el
     * usuario a escrito correctamente la contraseña
     * @throws BinainException
     */
    public static void valPassword(String pass, String passConf) throws BinainException {

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!-_@#$%^&+=])(?=\\S+$).{8,}";
        /*
        (?=.*[0-9]) un dígito debe aparecer al menos una vez
        (?=.*[a-z]) una letra minúscula debe aparecer al menos una vez
        (?=.*[A-Z]) una letra mayúscula debe aparecer al menos una vez
        (?=.*[!-_@#$%^&+=]) un carácter especial debe aparecer al menos una vez
        (?=\\S+$) no se permiten espacios en blanco en toda la cadena
        .{8,} Al menos 8 carácteres
         */
        System.out.println(pass.matches(pattern));
        if (!pass.equals(passConf)) {
            throw new BinainException(1);
        }
        if (pass.length() <= 8) {
            throw new BinainException(2);
        }
        if (!pass.matches(pattern)) {
            throw new BinainException(3);
        }
        //La contraseña no deberia contener ninguno de los otros campos del formulario, nick, nombre, nombre de banda o sala....
    }

    /**
     * Comprueba que la dirección de correo sea correcta y que cumple con los
     * estándares de ¿¿w3c???
     *
     * @param email : String que contiene la dirección de correo introducida por
     * el usuario
     * @throws BinainException
     */
    public static void valCorreo(String email) throws BinainException {

        String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*@[a-zA-Z0-9]*\\.[a-z]{2,4}$";
        /*
        ^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]* uno o más caracteres alfabéticos, numéricos o especiales, al principio de la cadena
        @ la arroba
        [a-zA-Z0-9]* uno o más caracteres alfabéticos o numéricos
        \\.[a-z]{3,4}$ tres o cuatro caracteres alfabéticos al final de la cadena
         */
        if (!email.matches(pattern)) {
            throw new BinainException(4);
        }
    }

    /**
     * Comprueba que uno de los dos radio button destinados a indicar el tipo de
     * usuario que se quiere crear este seleccionado.
     *
     * @param rbtnArtista
     * @param rbtnSala
     * @throws BinainException
     */
    public static void valTipoUser(JRadioButton rbtnArtista, JRadioButton rbtnSala) throws BinainException {

        if (rbtnArtista.isSelected() == false && rbtnSala.isSelected() == false) {
            throw new BinainException(5);
        }

    }

    /**
     * Comprueba que los campos enviados en el ArrayList no estén vacíos.
     *
     * @param campos : ArraList que incluye los campos del formulario que no
     * queremos que estén vacíos
     * @throws BinainException
     */
    public static void valCamposNull(ArrayList<JTextField> campos) throws BinainException {
        /*Estaria bien que el campo que este vacio lo pinte de alguna manera, pero
        después al hacer focus deberia volver a su color original */
        for (JTextField aux : campos) {
            if (aux.getText().isEmpty()) {
                throw new BinainException(6);
            }
        }

    }
}
