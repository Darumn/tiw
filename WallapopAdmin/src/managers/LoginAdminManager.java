package managers;

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
		usuario.setPassword(request.getParameter("password"));
		UserManager manager = new UserManager();
		try {
			usuario = manager.findUser(usuario);
			if (usuario != null && usuario.getIsAdmin()) {
				session.setUser(usuario);
				request.setAttribute("sessionUser", session);
<<<<<<< HEAD
=======
				request.setAttribute("error", null);
>>>>>>> branch 'master' of https://github.com/Darumn/tiw
				request.getRequestDispatcher("./indexAdmin.jsp").include(request, response);
			} else {
				request.setAttribute("error", "error");
				request.getRequestDispatcher("./login.jsp").include(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
