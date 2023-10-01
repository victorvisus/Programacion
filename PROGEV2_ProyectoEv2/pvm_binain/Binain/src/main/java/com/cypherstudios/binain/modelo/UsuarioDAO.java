package com.cypherstudios.binain.modelo;

import com.cypherstudios.binain.exception.*;
import java.sql.*;
import com.cypherstudios.binain.interfaces.IUsuarioDAO;
//import com.cypherstudios.binain.modelo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class UsuarioDAO extends Conexion implements IUsuarioDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;
    private String sql = "";

    private int idUsuario;

    //************************************* ACCIONES SOBRE LA BASE DE DATOS ****//
    /**
     * Realiza la insercción de los datos en MySQL
     *
     * @param usr
     * @return
     */
    @Override
    public void registrarUser(Usuario usr) throws SQLException {

        con = getConexion();

        sql = "INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES (?,?,?,?);";

        /* Primero añado al usuario para poder obtener el idUsuario */
        //Con PreparedStatement.RETURN_GENERATED_KEYS le indico que estoy interesado en la clave autoincremental
        ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, usr.getNickName());
        ps.setString(2, usr.getPassword());
        ps.setString(3, usr.getEmail());
        ps.setInt(4, usr.getIdTipoUsr());

        ps.executeUpdate();

        //Obtengo la clave autogenerada y la guardo en la variable de clase: idUsuario
        rs = ps.getGeneratedKeys();
        while (rs.next()) {
            idUsuario = rs.getInt(1);
        }

        insertDatosPersonales(usr);

        con.close();
    }

    @Override
    public void insertDatosPersonales(Usuario usr) throws SQLException {

        sql = "INSERT INTO datospersonales(nombre, apellido, direccion, localidad, idUsuario)"
                + " VALUES (?, ?, ?, ?, ?)";

        ps = con.prepareStatement(sql);

        ps.setString(1, usr.getDatosPersonales().getNombre());
        ps.setString(2, usr.getDatosPersonales().getApellido());
        ps.setString(3, usr.getDatosPersonales().getDireccion());
        ps.setString(4, usr.getDatosPersonales().getLocalidad());
        ps.setInt(5, idUsuario);

        ps.executeUpdate();
    }

    @Override
    public void insertSala(Sala sala) throws SQLException {
        con = getConexion();

        sql = "INSERT INTO salas(nombreSala, idUsuario)"
                + " VALUES (?,?)";

        ps = con.prepareStatement(sql);
        ps.setString(1, sala.getNombreSala());
        ps.setInt(2, idUsuario);

        ps.executeUpdate();

        con.close();
    }

    @Override
    public void insertArtista(Artista artista) throws SQLException {
        con = getConexion();

        sql = "INSERT INTO artistas(nombreArtista, idUsuario)"
                + " VALUES (?,?)";

        ps = con.prepareStatement(sql);
        ps.setString(1, artista.getNombreArtista());
        ps.setInt(2, idUsuario);

        ps.executeUpdate();

        con.close();
    }

    public void existeUsuario(Usuario usr) throws BinainException, SQLException {
        if (cuentaUsuarios(usr) > 0) {
            throw new BinainException(8);
        }
    }

    public void existeMail(Usuario usr) throws BinainException, SQLException {
        if (cuentaMail(usr) > 0) {
            throw new BinainException(7);
        }
    }

    /**
     * En caso de Exception desde la base de datos elimina cualquier rastro de
     * lo que se haya intentado registrar
     */
    public void deleteError() {
        con = getConexion();

        String sqlDel1 = "DELETE FROM usuarios WHERE (idUsuario = '" + idUsuario + "');";
        String sqlDel2 = "DELETE FROM datospersonales WHERE (idDatosPersonales = '" + idUsuario + "');";
        String sqlDel3 = "DELETE FROM salas WHERE (idUsuario = '" + idUsuario + "');";
        String sqlDel4 = "DELETE FROM artistas WHERE (idUsuario = '" + idUsuario + "');";

        try {
            ps = con.prepareStatement(sqlDel1);
            ps.executeUpdate();

            //Por lo que sea la base de datos no me borra el registro en esta tabla
            ps = con.prepareStatement(sqlDel2);
            ps.executeUpdate();

            ps = con.prepareStatement(sqlDel3);
            ps.executeUpdate();

            ps = con.prepareStatement(sqlDel4);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al limppiar el rastro del usuario"
                    + "\nMensaje SQLException: " + ex.getMessage()
                    + "\nCódgio de error: " + ex.getErrorCode());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión con la BBDD"
                        + "\nMensaje SQLException: " + ex.getMessage()
                        + "\nCódgio de error: " + ex.getErrorCode());
            }

        }
    }

    /**
     * Saca el tipo de usuario que esta registrado en la Base de Datos
     *
     * @param usr
     * @return
     * @throws SQLException
     * @throws BinainException
     */
    public String saberTipoUser(Usuario usr) throws SQLException, BinainException {
        String tipo = "";

        //Evalua que el usuario existe
        if (cuentaUsuarios(usr) == 0) {
            throw new BinainException(10);
        }

        con = getConexion();

        //sql = "SELECT idUsuario, nickName, password, email, idTipoUsr FROM usuarios WHERE nickName = ?";
        sql = "SELECT u.idUsuario, u.nickName, u.password, u.email, u.idTipoUsr, t.nombre"
                + " FROM usuarios AS u INNER JOIN tipo_usuarios AS t ON u.idTipoUsr = t.idTipoUsr"
                + " WHERE nickName = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getNickName());
        rs = ps.executeQuery();

        if (rs.next()) {
            //Evalua que la contraseña introducida es correcta
            if (!usr.getPassword().equals(rs.getString(3))) {
                throw new BinainException(9);
            }
            usr.setIdUsuario(rs.getInt(1));
            usr.setNickName(rs.getString(2));
            usr.setIdTipoUsr(rs.getInt(5));
            usr.setNombre_tipo(rs.getString(6));
            tipo = usr.getNombre_tipo();
        }
        con.close();

        return tipo;

    }

    /**
     *
     * @param usr
     * @param sala
     * @param datPerson
     * @throws SQLException
     */
    @Override
    public void iniciarSesionSala(Usuario usr, Sala sala, DatosPersonales datPerson) throws SQLException {

//        //Evalua que el usuario existe
//        if (cuentaUsuarios(usr) == 0) {
//            throw new BinainException(10);
//        }
        con = getConexion();

        //sql = "SELECT idUsuario, nickName, password, email, idTipoUsr FROM usuarios WHERE nickName = ?";
        sql = "SELECT u.idUsuario, u.nickName, u.password, u.email, u.idTipoUsr, t.nombre"
                + " FROM usuarios AS u INNER JOIN tipo_usuarios AS t ON u.idTipoUsr = t.idTipoUsr"
                + " WHERE nickName = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getNickName());
        rs = ps.executeQuery();

        if (rs.next()) {
            //Evalua que la contraseña introducida es correcta
//            if (!usr.getPassword().equals(rs.getString(3))) {
//                throw new BinainException(9);
//            }
            usr.setIdUsuario(rs.getInt(1));
            idUsuario = rs.getInt(1);
            usr.setNickName(rs.getString(2));
            usr.setPassword(rs.getString(3));
            usr.setEmail(rs.getString(4));
            usr.setIdTipoUsr(rs.getInt(5));
            usr.setNombre_tipo(rs.getString(6));

            usr.setDatosPersonales(montarDatPerson(datPerson));

            String sqlSala = "SELECT nombreSala FROM salas WHERE idUsuario = ?";
            ps = con.prepareStatement(sqlSala);
            ps.setInt(1, usr.getIdUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                sala.setNombreSala(rs.getString(1));
            }
            sala.setIdUsuario(usr.getIdUsuario());
            sala.setIdTipoUsr(usr.getIdTipoUsr());
            sala.setNombre_tipo(usr.getNombre_tipo());
            sala.setNickName(usr.getNickName());
            sala.setPassword(usr.getPassword());
            sala.setEmail(usr.getEmail());
            sala.setDatosPersonales(usr.getDatosPersonales());

        }
        con.close();
    }

    /**
     *
     * @param usr
     * @param artista
     * @param datPerson
     * @throws SQLException
     */
    @Override
    public void iniciarSesionArtista(Usuario usr, Artista artista, DatosPersonales datPerson) throws SQLException {

        //Evalua que el usuario existe
//        if (cuentaUsuarios(usr) == 0) {
//            throw new BinainException(10);
//        }
        con = getConexion();

        //sql = "SELECT idUsuario, nickName, password, email, idTipoUsr FROM usuarios WHERE nickName = ?";
        sql = "SELECT u.idUsuario, u.nickName, u.password, u.email, u.idTipoUsr, t.nombre"
                + " FROM usuarios AS u INNER JOIN tipo_usuarios AS t ON u.idTipoUsr = t.idTipoUsr"
                + " WHERE nickName = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getNickName());
        rs = ps.executeQuery();

        if (rs.next()) {
            //Evalua que la contraseña introducida es correcta
//            if (!usr.getPassword().equals(rs.getString(3))) {
//                throw new BinainException(9);
//            }
            usr.setIdUsuario(rs.getInt(1));
            idUsuario = rs.getInt(1);
            usr.setNickName(rs.getString(2));
            usr.setPassword(rs.getString(3));
            usr.setEmail(rs.getString(4));
            usr.setIdTipoUsr(rs.getInt(5));
            usr.setNombre_tipo(rs.getString(6));

            usr.setDatosPersonales(montarDatPerson(datPerson));

            String sqlArt = "SELECT nombreArtista FROM artistas WHERE idUsuario = ?";
            ps = con.prepareStatement(sqlArt);
            ps.setInt(1, usr.getIdUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                artista.setNombreArtista(rs.getString(1));
            }

            artista.setIdUsuario(usr.getIdUsuario());
            artista.setIdTipoUsr(usr.getIdTipoUsr());
            artista.setNombre_tipo(usr.getNombre_tipo());
            artista.setNickName(usr.getNickName());
            artista.setPassword(usr.getPassword());
            artista.setEmail(usr.getEmail());
            artista.setDatosPersonales(usr.getDatosPersonales());

        }
        con.close();
    }

    public DatosPersonales montarDatPerson(DatosPersonales datPerson) throws SQLException {
        datPerson = new DatosPersonales();
        //sql = "SELECT idUsuario, nickName, password, email, idTipoUsr FROM usuarios WHERE nickName = ?";
        sql = "SELECT idDatosPersonales, nombre, apellido, direccion, localidad FROM datospersonales WHERE idUsuario = ?";

        ps = con.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();

        if (rs.next()) {
            datPerson.setIdDatosPersonales(rs.getInt(1));
            datPerson.setNombre(rs.getString(2));
            datPerson.setApellido(rs.getString(3));
            datPerson.setDireccion(rs.getString(4));
            datPerson.setLocalidad(rs.getString(5));
        }

        return datPerson;
    }

    @Override
    public void modificarDatos(Usuario user) throws SQLException {
        con = getConexion();

        idUsuario = user.getIdUsuario();

        String sqlUpUsr = "UPDATE usuarios SET nickName = ?, email = ? WHERE (idUsuario = '" + idUsuario + "');";
        String sqlUpDat = "UPDATE datospersonales SET nombre = ?, apellido = ?, direccion = ?, localidad = ? WHERE (idDatosPersonales = '" + idUsuario + "');";
        String sqlUpSala = "UPDATE salas SET nombreSala = ? WHERE (idUsuario = '" + idUsuario + "');";
        String sqlUpArtista = "UPDATE artistas SET nombreArtista = ? WHERE (idUsuario = '" + idUsuario + "');";

        ps = con.prepareStatement(sqlUpUsr);
        ps.setString(1, user.getNickName());
        ps.setString(2, user.getEmail());
        System.out.println(sqlUpUsr);
        ps.executeUpdate();

        ps = con.prepareStatement(sqlUpDat);
        ps.setString(1, user.getDatosPersonales().getNombre());
        ps.setString(2, user.getDatosPersonales().getApellido());
        ps.setString(3, user.getDatosPersonales().getDireccion());
        ps.setString(4, user.getDatosPersonales().getLocalidad());
        System.out.println(sqlUpDat);
        ps.executeUpdate();

        if (user instanceof Sala) {
            ps = con.prepareStatement(sqlUpSala);
            ps.setString(1, ((Sala) user).getNombreSala());
            System.out.println(sqlUpSala);
            System.out.println(user.toString());
            ps.executeUpdate();
        } else if (user instanceof Artista) {
            ps = con.prepareStatement(sqlUpArtista);
            ps.setString(1, ((Artista) user).getNombreArtista());
            System.out.println(user.toString());
            System.out.println(sqlUpArtista);
            ps.executeUpdate();
        } else {
            JOptionPane.showMessageDialog(null, "Error con casteo user", "Actualizar Usuario", JOptionPane.ERROR_MESSAGE);
        }

        con.close();
    }

    @Override
    public void eliminarUsuario(Usuario user) throws SQLException {
        con = getConexion();

        idUsuario = user.getIdUsuario();

        String sqlDel1 = "DELETE FROM usuarios WHERE (idUsuario = '" + idUsuario + "');";
        String sqlDel2 = "DELETE FROM datospersonales WHERE (idDatosPersonales = '" + idUsuario + "');";
        String sqlDel3 = "DELETE FROM salas WHERE (idUsuario = '" + idUsuario + "');";
        String sqlDel4 = "DELETE FROM artistas WHERE (idUsuario = '" + idUsuario + "');";

        ps = con.prepareStatement(sqlDel1);
        ps.executeUpdate();

        ps = con.prepareStatement(sqlDel2);
        ps.executeUpdate();

        ps = con.prepareStatement(sqlDel3);
        ps.executeUpdate();

        ps = con.prepareStatement(sqlDel4);
        ps.executeUpdate();

        con.close();

    }

    //Métodos Auxiliares
    public int cuentaUsuarios(Usuario usr) throws SQLException {
        int num = 0;

        con = getConexion();

        //Cuenta los usuario que tiene el mismo nick que el introducido
        sql = "SELECT count(nickName) AS numero FROM usuarios WHERE nickName = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getNickName());
        rs = ps.executeQuery();

        while (rs.next()) {
            num = rs.getInt("numero");
        }

        con.close();
        return num;
    }

    public int cuentaMail(Usuario usr) throws SQLException {
        int num = 0;

        con = getConexion();

        //Cuenta los usuario que tiene el mismo mail que el introducido
        sql = "SELECT count(email) AS numero FROM usuarios WHERE email = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, usr.getEmail());
        rs = ps.executeQuery();

        while (rs.next()) {
            num = rs.getInt("numero");
        }

        con.close();
        return num;
    }
}
