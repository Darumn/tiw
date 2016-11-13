package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.*;
import model.*;

public class LoginAdminManager extends AdminManager {

	public LoginAdminManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);

		// Nothing to do.
	}

	@Override
	public void Execute() {
		User usuario = new User();
		usuario.setEmail(request.getParameter("user"));

		usuario.setPassword(LoginAdminManager.getHash((String) request.getParameter("password"), "SHA-1"));
		UserManager manager = new UserManager();
		try {
			usuario = manager.findUser(usuario);
			if (usuario != null && usuario.getIsAdmin() == 1) {
				session.setUser(usuario);
				request.setAttribute("sessionUser", session);
				request.setAttribute("error", null);
				request.getRequestDispatcher("./indexAdmin.jsp").include(request, response);
			} else {
				request.setAttribute("error", "error");
				request.getRequestDispatcher("./login.jsp").include(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				request.getRequestDispatcher("./login.jsp").include(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String sha1(String txt) {
		return LoginAdminManager.getHash(txt, "SHA1");
	}

}
