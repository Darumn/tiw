package managers;

import java.io.IOException;

import javax.servlet.ServletException;
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

		User user = new User();
		UserManager userManager = new UserManager();
		String id2 = request.getParameter("id");

		try {
			userOld = manager.findUserById(idUser);

			user = userManager.findUserById(Integer.parseInt(id2));
			session.setUser(user);
			request.setAttribute("sessionUser", session);
			request.setAttribute("old user", userOld);
			request.getRequestDispatcher("./SelectEditUser.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.getRequestDispatcher("./login.jsp").include(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
