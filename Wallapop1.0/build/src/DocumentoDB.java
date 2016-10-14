import java.sql.ResultSet;

public class DocumentoDB {

	public static String modeloQuery = "select  * from documentos ";
	public static String modeloInsert = "Insert into documentos (id,path) values";
	
	public int id = 0;
	public String path = "";
	private Documento doc = null;
	
	public static DocumentoDB Iniciar(Documento pD){
		
		DocumentoDB ret = null;
		
		ret = DocumentoDB.ObtenerPorPath(pD.path);
		
		int id = 0;
		if(ret != null){
			id = ret.id;
		}
		
		ret = new DocumentoDB(pD);
		ret.id = id;
		pD.id = id;
		
		return ret;
	}
	
	public DocumentoDB(){
		
	}
	
	public DocumentoDB(Documento pD){
		this.path = pD.path;
		this.setDoc(pD);
	}
	
	public DocumentoDB(ResultSet rs){
		try{
			this.id = rs.getInt(1);
			this.path = rs.getString(2);
		}
		catch(Exception e){
			
		}
	}
	
	public Documento getDoc() {
		return doc;
	}

	public void setDoc(Documento doc) {
		this.doc = doc;
		this.doc.setDoc(this);
	}
	
	public boolean insertarOActualizar(){
		
		boolean ret = false;
		
		if(this.id > 0){
			ret = this.actualizar();
		}
		else{
			ret = this.insertar();
		}
		
		return ret;
		
	}

	public boolean insertar(){
		boolean ret = false;
		String query = modeloInsert + this.getInsertString() + ";";
		Entero auto = new Entero(0);
		if(baseDeDatos.insertarActualizar(query, auto)){
			this.id = auto.getValue();
			ret = true;
			this.doc.id = this.id;
		}
	
		return ret;
	}
	
	public String getInsertString(){
		String query = " (";
		
		query += this.id + ",";
		query += "'"+this.path + "'";
		
		query += ")";
		
		return query;
	}
	
	public boolean actualizar(){
		boolean ret = false;
		String query = "update documentos set ";
		
		query += "path = '"+this.path + "'";
		query += "where id = " + this.id + ";";
		
		Entero auto = new Entero(-1);
		if(baseDeDatos.insertarActualizar(query, auto)){
			this.id = auto.getValue();
			ret = true;
		}
	
		return ret;
	}
	
	public static DocumentoDB ObtenerPorId(long pId){
		
		DocumentoDB ret = null;
		
		String query = modeloQuery + "where id = "+pId+";";
		baseDeDatos bd = baseDeDatos.getResulSet(query);
		try{
			if(bd != null && bd.rs.next()){
				ret = new DocumentoDB(bd.rs);
			}
		}
		catch(Exception e){
			ret = null;
		}
		
		bd.cerrar();
		
		return ret;	
	}
	
	public static DocumentoDB ObtenerPorPath(String path){
		
		DocumentoDB ret = null;
		
		String query = modeloQuery + "where path = '"+path+"'";
		baseDeDatos bd = baseDeDatos.getResulSet(query);
		try{
			if(bd.rs != null && bd.rs.next()){
				ret = new DocumentoDB(bd.rs);
			}
			
			bd.cerrar();
		}
		catch(Exception e){
			ret = null;
		}

		return ret;	
	}
}