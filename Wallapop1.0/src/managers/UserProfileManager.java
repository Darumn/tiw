package managers;
import model.*;
import logic.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserProfileManager extends Manager {

	public UserProfileManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		try{
			User user= this.session.getUser();
			request.setAttribute("user", user);
			request.getRequestDispatcher("./PerfilUsuario.jsp").include(request, response);

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
