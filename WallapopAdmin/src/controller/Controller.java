package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.*;

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
			} else if (action.equals("DeleteUser")) {
				manager = new DeleteUser(request, response);
				manager.Execute();
			} else if (action.equals("AdminLogin")) {
				manager = new LoginAdminManager(request, response);
				manager.Execute();
			} else if (action.equals("CloseSession")) {
				manager = new CloseSession(request, response);
				manager.Execute();
			} else if (action.equals("ShowProducts")) {
				manager = new ShowProducts(request, response);
				manager.Execute();
			} else if (action.equals("SelectEditProduct")) {
				manager = new SelectEditProduct(request, response);
				manager.Execute();
			} else if (action.equals("EditProduct")) {
				manager = new EditProduct(request, response);
				manager.Execute();
			} else if (action.equals("DeleteProduct")) {
				manager = new DeleteProduct(request, response);
				manager.Execute();
			} else {
				request.getRequestDispatcher("./failure.jsp").forward(request, response);
			}

		}
		// Caso de index
		else {
			manager = new IndexAdminManager(request, response);
			}
		request.getRequestDispatcher("./includes/header.jsp").include(request, response);
		manager.Execute();
		request.getRequestDispatcher("./includes/footer.jsp").include(request, response);
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
