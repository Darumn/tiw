package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.Manager;
import managers.IndexAdminManager;
import managers.LoginAdminManager;
import managers.AdminManager;
/*import managers.ProductCatalogManager;
import managers.RegisterProductManager;
import managers.RegisterUserManager;
import managers.UserProfileManager;*/
import managers.ShowUsers;
import managers.SelectEditUser;
import managers.EditUser;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("redirect");

		AdminManager manager = null;

		if (action != null && !action.equals("")) {

			if (action.equals("ShowUsers")) {
				manager = new ShowUsers(request, response);
				manager.Execute();
			} else if (action.equals("SelectEditUser")) {
				manager = new SelectEditUser(request, response);
				manager.Execute();
			} else if (action.equals("EditUser")) {
				manager = new EditUser(request, response);
				manager.Execute();
			}

			else {
				request.getRequestDispatcher("./failure.jsp").forward(request, response);
			}

		}
		// Caso de index
		else {
			manager = new IndexAdminManager(request, response);
			manager.Execute();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
