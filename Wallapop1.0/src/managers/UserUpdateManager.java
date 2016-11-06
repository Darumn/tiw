package managers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
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
				usuario.setName(name);
			}
			
			if(name != null && !name.equals("")){
				usuario.setSurname(surname);
			}
			
			if(name != null && !name.equals("")){
				usuario.setEmail(email);
			}
			
			if(name != null && !name.equals("")){
				usuario.setPassword(pass);
			}
			
			if(name != null && !name.equals("")){
				usuario.setCity(city);
			}
			
			manager.updatePersona(usuario);
			
			this.manageImage(usuario);
			
			//request.setAttribute("user", usuario);
			//request.getRequestDispatcher("./PerfilUsuario.jsp").include(request, response);
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
			 
		}
	}
	
	private void manageImage(User usuario) throws IOException, ServletException{
		Part filePart = request.getPart("image");
		if(filePart != null){
			
			
		    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		    InputStream fileContent = filePart.getInputStream();
		    
		    File file = new File(Manager.userDirectoryFullPath+"/"+usuario.getId()+".jpg");

		    try {
		    	
		        Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    }
		    catch(IOException e){
		    	
		    	
		    }
		    
		}
	}

}
