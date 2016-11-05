
import model.*;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String action = request.getParameter("redirect");

		// HttpSession session = request.getSession(true);

		Manager manager = null;

		if (action != null && !action.equals("")) {

			if (action.equals("Login")) {
				manager = new LoginManager(request, response);
				manager.Execute();
				if(request.getAttribute("session") != null) System.out.println("Hay una sesion debtroi ");
				manager = new IndexManager(request, response);
				//request.getRequestDispatcher("./index.jsp").forward(request, response);

			} else if (action.equals("RegisterUserManager")) {
				manager = new RegisterUserManager(request, response);
				request.getRequestDispatcher("./index.jsp").forward(request, response);

			} else if (action.equals("RegisterProductManager")) {
				manager = new RegisterProductManager(request, response);
				request.getRequestDispatcher("./Viewproductsseller.jsp").forward(request, response);

			} else if (action.equals("UserProfile")) {
				manager = new UserProfileManager(request, response);

			} else if (action.equals("ProductCatalog")) {
				manager = new ProductCatalogManager(request, response);
			} else if (action.equals("Product")) {
				manager = new ProductViewManager(request, response);
			}

			request.getRequestDispatcher("./includes/header.jsp").include(request, response);
			manager.Execute();
			request.getRequestDispatcher("./includes/footer.jsp").include(request, response);

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
