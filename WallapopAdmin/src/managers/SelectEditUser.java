package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class SelectEditUser extends AdminManager {

	public SelectEditUser(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		UserManager manager = new UserManager();
		User userOld;
		String id = request.getParameter("id_object");
		int idUser = Integer.parseInt(id);

		try {
			userOld = manager.findUserById(idUser);
			SessionAdminManager sessionUser = new SessionAdminManager(this.request, this.response);

			if (sessionUser.getUser() != null) {
				request.setAttribute("sessionUser", sessionUser);
			}
			request.setAttribute("old user", userOld);
			request.getRequestDispatcher("./SelectEditUser.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
