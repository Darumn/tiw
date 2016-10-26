package datos;
import java.sql.*;
public class AccesoDatos {

	Connection con;
	Statement st;
	ResultSet rs;
	/*Método para abrir la conexion*/
	public void abrirConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("");
			System.out.println("Conexión a la BD");
		} catch(Exception e){
			System.out.println("Erron en la conexión a la BD");
		}
	}
	/*Método que cierra la conexión con la base de datos*/
	public void cerrarConexion(){
		try{
			con.close();
			System.out.println("Conexion cerrada");
		} catch(Exception e){
			System.out.println("Error al cerrar la conexión");
		}
	}
	
	/*Método para insertar datos en la base de datos usuarios*/
	public void insertar(String n,String s,String c,String p){
		try{
			Statement s1=con.createStatement();
			s1.executeUpdate("INSERT INTO persona (edad,nombre) values ("
					+ n + ",'" + s + ",'"+c+ "',"+p+ "')");
		} catch(SQLException e){
			System.out.println("Error al insertar datos en la tabla usuarios");
		}
	}
	/*Método para modificar los datos de la tabla usuarios*/
	
	/*Método para borrar los datos de la tabla usuarios*/
	
}
