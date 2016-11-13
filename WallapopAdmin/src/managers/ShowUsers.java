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
		
		User user = new User();
		UserManager userManager2 = new UserManager();
		String id = request.getParameter("id");
		try {
			usersList = users.showUsers();
			
			user = userManager2.findUserById(Integer.parseInt(id));
			session.setUser(user);
			request.setAttribute("sessionUser", session);

			request.setAttribute("users list", usersList);
			request.getRequestDispatcher("./UsersList.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
