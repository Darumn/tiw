package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import model.*;

public class LoginManager extends Manager {

	public LoginManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		
		//Nothing to do.
	}

	@Override
	public void Execute() {
		User usuario = null;
		UserManager manager = new UserManager();
		try{
			usuario = manager.findUser(this.request.getParameter("user"),this.request.getParameter("password"));
			this.request.getRequestDispatcher("/index.jsp").forward(request, response);
            
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		//TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..
		
	}
	
	

}
