package com.cypherstudios.binain.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Realiza la conexión a la Base de datos MySQL
 *
 * @author Víctor Visús García
 */
public class Conexion {

    private final String serverPrep = "useServerPrepStmts=true";
    private final String useSSL = "useSSL=false";
    private final String timeZone = "useTimezone=true";
    private final String serverTimeZone = "serverTimezone=UTC";
    private final String allowPublicKey = "allowPublicKeyRetrieval=true";

    private final String BASE = "binain_mvp";
    //private final String BASE = "test";
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/" + BASE + "?" + serverPrep + "&" + useSSL + "&" + timeZone + "&" + serverTimeZone + "&" + allowPublicKey;

    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = "admin";

    //Variable para crear la conexión, guardarla y devolverla
    protected Connection con = null;

    /**
     * Establece la conexión con la base de datos
     *
     * @return conexion
     */
    public Connection getConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.JDBC_URL, this.JDBC_USER, this.JDBC_PASSWORD);

        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return con;
    }
}
