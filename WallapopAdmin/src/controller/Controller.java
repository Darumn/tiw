package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.IndexManager;
import managers.LoginManager;
import managers.Manager;
/*import managers.ProductCatalogManager;
import managers.RegisterProductManager;
import managers.RegisterUserManager;
import managers.UserProfileManager;*/
import managers.ShowUsers;

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

		Manager manager = null;

		if (action != null && !action.equals("")) {

			if (action.equals("ShowUsers")) {
				manager = new ShowUsers(request, response);
				request.getRequestDispatcher("./UsersList.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("./failure.jsp").forward(request, response);
			}

			manager.Execute();

		}
		// Caso de index
		else {
			manager = new IndexManager(request, response);
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
