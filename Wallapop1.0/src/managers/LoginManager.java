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
		usuario.setPassword(request.getParameter("password"));
		UserManager manager = new UserManager();
		try {
			usuario = manager.findUser(usuario);
			if(usuario != null){
				session.setUser(usuario);
				request.setAttribute("session", session);
			}
			else {
				request.getRequestDispatcher("./Formulario.jsp").include(request, response);
			}
			//request.setAttribute("user", usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..

	}

}
