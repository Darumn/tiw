package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.setAttribute("users list", usersList);
			request.getRequestDispatcher("./UsersList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
