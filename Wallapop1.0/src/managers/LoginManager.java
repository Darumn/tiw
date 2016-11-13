package managers;

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
		//System.out.println("Clave cifrada login: "+RegisterUserManager.getHash((String)request.getParameter("pass"), "SHA-1"));
		UserManager manager = new UserManager();
		try {
			usuario = manager.findUser(usuario);
			if(usuario != null){
				session.setUser(usuario);
				request.setAttribute("session", session);
			}
			/*else {
				request.getRequestDispatcher("./Formulario.jsp").include(request, response);
			}*/
			//request.setAttribute("user", usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..

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
