package basededatos;

import java.sql.*;
import java.util.Hashtable;

public class Conexion {
	private Connection conexion = null;
	private String servidor;
	private String database;
	private String usuario;
	private String password;
	private String url;
	private Statement stm;
	private ResultSet rs;

	public Conexion(String servidor, String database, String usuario, String password) {
		try {
			this.servidor = servidor;
			this.database = database;
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://" + servidor + "/" + database;
			conexion = DriverManager.getConnection(url, usuario, password);
			if (conexion != null) {
				System.out.println("Conexión a base de datos: " + url + " Ok");
			}
		}

		catch (SQLException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConexion() {
		return conexion;
	}

	public ResultSet search(String tabla) throws SQLException {
		rs = stm.executeQuery("SELECT * FROM" + tabla);
		return rs;
	}

	public void insertar(Hashtable user) {
		try {
			stm.executeQuery("INSERT INTO usuarios (id,name,surname,city,password) VALUES (" + user.get("id") + ","
					+ user.get("name") + "," + user.get("city") + "," + user.get("password") + ")");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public void actualizar(String tabla, Hashtable user, String nombre) {
		try {
			stm.execute("UPDATE" + tabla + "SET name='" + user.get("name") + "'WHERE nombre='" + nombre + "'");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public void eliminar(String tabla, String nombre) {
		try {
			stm.execute("DELETE FROM" + tabla + "WHERE nombre='" + nombre + "'");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public Connection cerrarConexion() {
		try {
			conexion.close();
			System.out.println("Cerrando conexion a " + url + " ok");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		conexion = null;
		return conexion;
	}
}
