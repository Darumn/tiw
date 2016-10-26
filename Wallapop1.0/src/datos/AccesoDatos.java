package datos;
import java.sql.*;
public class AccesoDatos {

	Connection con;
	Statement st;
	ResultSet rs;
	/*M�todo para abrir la conexion*/
	public void abrirConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("");
			System.out.println("Conexi�n a la BD");
		} catch(Exception e){
			System.out.println("Erron en la conexi�n a la BD");
		}
	}
	/*M�todo que cierra la conexi�n con la base de datos*/
	public void cerrarConexion(){
		try{
			con.close();
			System.out.println("Conexion cerrada");
		} catch(Exception e){
			System.out.println("Error al cerrar la conexi�n");
		}
	}
	
	/*M�todo para insertar datos en la base de datos usuarios*/
	public void insertar(String n,String s,String c,String p){
		try{
			Statement s1=con.createStatement();
			s1.executeUpdate("INSERT INTO persona (edad,nombre) values ("
					+ n + ",'" + s + ",'"+c+ "',"+p+ "')");
		} catch(SQLException e){
			System.out.println("Error al insertar datos en la tabla usuarios");
		}
	}
	/*M�todo para modificar los datos de la tabla usuarios*/
	
	/*M�todo para borrar los datos de la tabla usuarios*/
	
}
