package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		usuario.setEmail(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("password"));
		usuario.setId(-1);
		UserManager manager = new UserManager();
		try {
			manager.findUser(usuario);
			request.setAttribute("user", usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO COMPROBAR USUARIO Y CONTRASEÑA EN LA BD, ETC..

	}

}
