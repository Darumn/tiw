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
		String strid=this.request.getParameter("id");
		int id=Integer.parseInt(strid);
		UserManager manager=new UserManager();
		try{
			User user= manager.findUserById(id);
			this.request.setAttribute("user", user);
			request.getRequestDispatcher("./PerfilUsuario.jsp").forward(request, response);
		}
		catch(Exception e){
			
		}
	}
	
	
	

}
