package managers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
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
		 
		usuario.setName(((String)request.getParameter("name")).toLowerCase());
		usuario.setSurname(((String)request.getParameter("surname")).toLowerCase());
		usuario.setEmail((String)request.getParameter("email"));
		
		usuario.setPassword(RegisterUserManager.getHash((String)request.getParameter("pass"), "SHA-1"));
		
		usuario.setCity(((String)request.getParameter("city")).toLowerCase());
		try{
			manager.createUser(usuario);
			request.setAttribute("user", usuario);
			session.setUser(usuario);
			request.setAttribute("session", session);
			
		}
		 catch (Exception e) {
			// TODO: handle exception
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
	public static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
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
 
   
 
    /* Retorna un hash SHA1 a partir de un texto */
    public static String sha1(String txt) {
        return RegisterUserManager.getHash(txt, "SHA1");
    }
}
