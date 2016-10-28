package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginManager extends Manager {

	public LoginManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		
		//Nothing to do.
	}

	@Override
	public void Execute() {
		String usuario = this.request.getParameter("user");
		String pass = this.request.getParameter("pass");
		
		//TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..
		
	}
	
	

}
