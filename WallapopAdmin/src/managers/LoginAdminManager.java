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
				//SessionAdminManager sessionUser = new SessionAdminManager(request, response);
				//sessionUser.setUser(usuario);
				session.setUser(usuario);
				request.setAttribute("sessionUser", session);
				request.getRequestDispatcher("./index.jsp").include(request, response);
			} else {
				request.getRequestDispatcher("./failure.jsp").include(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
