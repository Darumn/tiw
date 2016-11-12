package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class DeleteUser extends AdminManager {

	public DeleteUser(HttpServletRequest pRequest, HttpServletResponse pResponse) {
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
			//manager.deletePersona(userOld);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
