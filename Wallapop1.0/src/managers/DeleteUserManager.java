package managers;
import model.*;
import logic.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserManager extends Manager {

	public DeleteUserManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
		UserManager manager = new UserManager();
		User userOld;
		String id = request.getParameter("id");
		int idUser = Integer.parseInt(id);

		try {
			userOld = manager.findUserById(idUser);
			manager = new UserManager();
			manager.deleteUser((userOld));
			manager = new UserManager();
			request.getRequestDispatcher("./Controller").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}