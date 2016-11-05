package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class SelectEditUser extends Manager {

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
			request.setAttribute("old user", userOld);
			request.getRequestDispatcher("./SelectEditUser.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
