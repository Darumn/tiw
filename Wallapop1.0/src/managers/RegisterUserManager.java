package managers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import logic.*;

public class RegisterUserManager extends Manager{
	
	public RegisterUserManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}
	
	public void Execute(){
		User usuario = new User();
		UserManager manager = new UserManager();
		
		usuario.setName(((String)request.getParameter("name")));
		usuario.setSurname((String)request.getParameter("surname"));
		usuario.setEmail((String)request.getParameter("email"));
		usuario.setPassword((String)request.getParameter("pass"));
		System.out.println("La contraseña es: "+usuario.getPassword()+" de : "+ request.getParameter("pass"));
		usuario.setCity((String)request.getParameter("city"));
		try{
			manager.createUser(usuario);
			request.setAttribute("user", usuario);
			session.setUser(usuario);
			request.setAttribute("session", session);
			
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
			 
		}
		
		
	}
}
