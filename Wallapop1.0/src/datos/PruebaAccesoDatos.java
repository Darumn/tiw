package datos;

public class PruebaAccesoDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			AccesoDatos db=new AccesoDatos();
			db.abrirConexion();
			db.insertar("PEPE","PEREZ");
			
	}

}
