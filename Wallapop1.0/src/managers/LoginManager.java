package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import model.*;
import model.User;

public class LoginManager extends Manager {

	public LoginManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);

		// Nothing to do.
	}

	@Override
	public void Execute() {
		User usuario = new User();
		usuario.setEmail(request.getParameter("user"));
		
		usuario.setPassword(RegisterUserManager.getHash((String)request.getParameter("password"), "SHA-1"));
		UserManager manager = new UserManager();
		try {
			usuario = manager.findUser(usuario);
			if(usuario != null){
				session.setUser(usuario);
				request.setAttribute("session", session);
			}		

		} catch (Exception e) {
			System.out.println(e.getMessage());
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
