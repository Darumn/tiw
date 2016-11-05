package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import model.*;

public class LoginManager extends Manager {

	public LoginManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);

		// Nothing to do.
	}

	@Override
	public void Execute() {
		User usuario = new User();
		usuario.setEmail(request.getParameter("user"));
		usuario.setPassword(request.getParameter("password"));
		UserManager manager = new UserManager();
		try {
			usuario = manager.findUser(usuario);
			SessionManager session = new SessionManager(request, response);
			session.setUser(usuario);
			request.setAttribute("session", session);
			//request.setAttribute("user", usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..

	}

}
