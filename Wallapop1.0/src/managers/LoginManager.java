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
		User usuario = new User();
		UserManager manager = new UserManager();
		usuario.setEmail(this.request.getParameter("user"));
		usuario.setPassword(this.request.getParameter("password"));
		try{
			manager.findUser(usuario);
			this.request.getRequestDispatcher("/index.jsp").forward(request, response);
            
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		//TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..
		
	}
	
	

}
