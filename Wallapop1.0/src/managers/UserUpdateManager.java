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
			String pass = RegisterUserManager.getHash((String)request.getParameter("pass"), "SHA-1");
			String city = request.getParameter("city");
			
			if(name != null && !name.equals("")){
				usuario.setName(name.toLowerCase());
			}
			
			if(surname != null && !surname.equals("")){
				usuario.setSurname(surname.toLowerCase());
			}
			
			if(email != null && !email.equals("")){
				usuario.setEmail(email);
			}
			
			if(pass != null && !pass.equals("")){
				usuario.setPassword(pass);
			}
			
			if(city != null && !city.equals("")){
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
	
	

	public static String getHash(String password, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
 
   
 
    
    public static String sha1(String txt) {
        return RegisterUserManager.getHash(txt, "SHA1");
    }
	
}
