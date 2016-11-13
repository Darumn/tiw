package managers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import logic.UserManager;
import model.User;

public class UserUpdateManager extends Manager {

	public UserUpdateManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		
		User usuario = null;
		UserManager manager = new UserManager();
		
		try{
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			usuario = manager.findUserById(id);
		
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String city = request.getParameter("city");
			
			if(name != null && !name.equals("")){
				usuario.setName(name.toLowerCase());
			}
			
			if(name != null && !name.equals("")){
				usuario.setSurname(surname.toLowerCase());
			}
			
			if(name != null && !name.equals("")){
				usuario.setEmail(email);
			}
			
			if(name != null && !name.equals("")){
				usuario.setPassword(pass);
			}
			
			if(name != null && !name.equals("")){
				usuario.setCity(city.toLowerCase());
			}
			
			manager.updatePersona(usuario);
			
			
		}
		 catch (Exception e) {
			// TODO: handle exception
			 try {
				request.getRequestDispatcher("./index.jsp").include(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		}
	}
	
	

}
