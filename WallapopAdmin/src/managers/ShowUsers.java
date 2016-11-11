package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import logic.*;

import java.util.List;

public class ShowUsers extends AdminManager {

	public ShowUsers(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {

		UserManager users = new UserManager();
		List<User> usersList;
		try {
			usersList = users.showUsers();
			SessionAdminManager sessionUser = new SessionAdminManager(this.request, this.response);

			if (sessionUser.getUser() != null) {
				request.setAttribute("sessionUser", sessionUser);
			}
			request.setAttribute("users list", usersList);
			request.getRequestDispatcher("./UsersList.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
