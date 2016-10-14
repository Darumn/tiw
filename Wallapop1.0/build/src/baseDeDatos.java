import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class baseDeDatos {

	Connection conn = null; 
	Statement stmt = null;
	ResultSet rs = null;
	
	public baseDeDatos(Connection pConexion, Statement pStatement, ResultSet pResulset){
		this.conn = pConexion;
		this.stmt = pStatement;
		this.rs = pResulset;
	}
	
	public void cerrar(){
		try
		{
			if(this.rs != null){
				this.rs.close();
			}
			
			if(this.stmt != null){
				this.stmt.close();
			}
			
			if(this.conn != null){
				baseDeDatos.cerrarConexion(this.conn);
			}
		}
		catch(Exception e){
			
		}
	}
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://5.9.67.39:3307/rai?useUnicode=true&characterEncoding=UTF-8";
	
	static final String USER = "rai";
	static final String PASS = "@Rai2016_@";
	
	private static ArrayList<Connection> conexiones = new ArrayList<Connection>();
	private static ArrayList<Boolean> enUso = new ArrayList<Boolean>();
	
	public static Connection getConexion(){
		
		Connection conn = null;
		try{
		//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
		
		//STEP 3: Open a connection
			//System.out.println("Connecting to database...");
			
			for(int i=0; i< enUso.size() && conn == null;i++){
				if(!enUso.get(i)){
					if(conexiones.get(i).isClosed()){
						conn = DriverManager.getConnection(DB_URL,USER,PASS);
						conexiones.set(i, conn);
					}
					else{
						conn = conexiones.get(i);
					}
					enUso.set(i, true);
				}
			}
			
			if(conn == null){
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				conexiones.add(conn);
				enUso.add(true);
			}
		}
		catch(Exception e)
		{
			conn = null;
		}
   
		return conn;
	}
	
	
	public static baseDeDatos getResulSet(String query){
		
		Connection conn = getConexion(); 
		Statement stmt = null;
		ResultSet rs = null;

		if(conn != null){
		
			try
			{
		//STEP 4: Execute a query
				//System.out.println("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				rs = stmt.executeQuery(query);
			}
			catch(Exception e){
				
			}
		}
		
		/*try{
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				cerrarConexion(conn);
			}
		}
		catch(Exception e){
		
		}*/
		
		return new baseDeDatos(conn,stmt,rs);
	}
	
	public static boolean insertarActualizar(String query, Entero columnaAutoGenerada){
		Connection conn = getConexion(); 
		Statement stmt = null;
		
		boolean ret = false;

		if(conn != null){
		
			try
			{
		//STEP 4: Execute a query
				//System.out.println("Creating statement...");
				stmt = conn.createStatement();
				ret = stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS) > 0;
				
				if(columnaAutoGenerada.getValue()>-1) {
				   ResultSet rs = stmt.getGeneratedKeys();
				   rs.next();
				   columnaAutoGenerada.setValue(rs.getInt(1));
				   rs.close();
				}
				
			}
			catch(Exception e){
				
			}
		}
		
		try{
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				cerrarConexion(conn);
			}
		}
		catch(Exception e){
			
		}
		
		return ret;
	}
	
	
	public static void cerrarConexion(Connection conn){
		
		int indice = conexiones.indexOf(conn);
		if(indice > -1){
			enUso.set(indice, false);
		}
	}
}
