package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioManager extends Manager{

	public FormularioManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		try{
			this.request.getRequestDispatcher("./Formulario.jsp").include(this.request, this.response);
		}
		catch(Exception e){
			
		}
	}

}
