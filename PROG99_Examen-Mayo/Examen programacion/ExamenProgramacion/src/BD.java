import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BD {

	private static BD miInstancia = null;
	private static boolean permitirInstancianueva;
	private String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE";
	private String usuario = "matricula";
	private String password = "matricula";
	private Connection conn;
	private Statement stmt;

	BD() throws Exception {
		if (!permitirInstancianueva) {
			throw new Exception("No se puede crear la instancia, usa getInstance");
		}
	}

	public static BD getInstance() {
		if (miInstancia == null) {
			permitirInstancianueva = true;
			try {
				miInstancia = new BD();
			} catch (Exception e) {
				e.printStackTrace();
			}
			permitirInstancianueva = false;
		}
		return miInstancia;
	}

	public ResultSet consultaBD(String consulta) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		conn = DriverManager.getConnection(cadenaConexion, usuario, password);

		stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(consulta);

		return rset;
	}

	public void cerrarConsulta() throws SQLException {
		stmt.close();
	}

	public String getCadenaConexion() {
		return cadenaConexion;
	}

	public void setCadenaConexion(String cadenaConexion) {
		this.cadenaConexion = cadenaConexion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	/**
	 * Encontrar si existe el patrón dado dentro de una palabra
	 *
	 * @param word  palabra de la que se quiere detectar el patron
	 * @param regex patron que se quiere encontrar
	 * @return patron encontrado, si no tiene devuelve null
	 */
	private String findPattern(String word, String regex) {
		String patternFound = null;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(word);
		while (matcher.find()) {
			patternFound = matcher.group(1);
		}
		return patternFound;
	}

}
