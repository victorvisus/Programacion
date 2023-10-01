package com.cypherstudios.binain.exception;

/**
 *
 * @author Victor
 */
public class BinainException extends Exception {

    private int codigoError;

    public BinainException() {
    }

    /**
     *
     * @param codigoError
     */
    public BinainException(int codigoError) {
        super();
        this.codigoError = codigoError;
    }

    /**
     * Dependiendo del número de error recibido lanza un mensaje u otro
     *
     * @return mensaje de error
     */
    public String getMessage() {
        String msjError = "";
        System.out.println(codigoError);
        switch (codigoError) {

            case 1:
                //REGISTRO DE USUARIO: Contraseña no-Valida
                msjError = "Las contraseñas introducidas no coinciden";
                break;
            case 2:
                msjError = "La contraseña no puede tener menos de 8 caracteres";
                break;
            case 3:
                msjError = "La contraseña debe incluir números, letras en mayúsculas y minúsculas y algún caracter especial ( !-_@#$%^&+= )";
                break;
            case 4:
                //REGISTRO DE USUARIO: e-mail no-Valido
                msjError = "La dirección de e-mail no es correcta";
                break;
            case 5:
                //REGISTRO DE USUARIO: RadioButton tiene que haber uno seleccionado
                msjError = "Debes elegir un tipo de usuario: Sala o Artista";
                break;
            case 6:
                //REGISTRO DE USUARIO: Campos del formulario vacios
                msjError = "Hay campos que no pueden estar vacios";
                break;
            case 7:
                //REGISTRO DE USUARIO: Mail ya existe
                msjError = "La dirección de e-mail ya se encuentra en el sistema";
                break;
            case 8:
                //REGISTRO DE USUARIO: Usuario ya existe
                msjError = "El usuario ya existe";
                break;
            case 9:
                //INICIO DE SESIÓN: Contraseña incorrecta
                msjError = "La contraseña es incorrecta";
                break;
            case 10:
                //INICIO DE SESIÓN: El usuario no existe
                msjError = "El usuario no existe";
                break;
            default:
                msjError = "Error de ejecución";
                break;
        }

        return msjError;
    }

}
