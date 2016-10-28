package datos;
import java.sql.*;
import model.*;

public class AccesoDatos {
	
	Connection con;
	Statement st;
	//ResultSet rs;
	String userName = "root";
	String password = "admin";

		
	/*M�todo para abrir la conexion*/
	public void abrirConexion(){
		
		try{
			System.out.println("Conexi�n a la BD");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=" + userName+  "&password=" + password);
			
			
		} catch(Exception e){
			System.out.println(e.toString());
			System.out.println("Error en la conexion");
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
	public void insertar(String n,String s){
		try{
			Statement s1=con.createStatement();
		s1.executeUpdate("INSERT INTO user (name,surname) values ('"+ n + "','" + s + "')");
		
		} catch(SQLException e){
			System.out.println(e.toString());
			System.out.println("Error al insertar datos en la tabla usuarios");
		}
	}
	/*M�todo para modificar los datos de la tabla usuarios*/
	
	/*M�todo para borrar los datos de la tabla usuarios*/
	
}
