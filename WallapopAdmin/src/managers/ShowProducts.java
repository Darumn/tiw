package managers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class ShowProducts extends AdminManager {

	public ShowProducts(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		ProductManager products = new ProductManager();
		List<Product> productsList;
		
		User user = new User();
		UserManager userManager = new UserManager();
		String id = request.getParameter("id");
		try {
			productsList = products.findAllProducts();

			// SessionAdminManager sessionUser = (SessionAdminManager)
			// request.getAttribute("sessionUser");

			/*
			 * if (session.getUser() != null) {
			 * request.setAttribute("sessionUser", sessionUser); }
			 */
			user = userManager.findUserById(Integer.parseInt(id));
			session.setUser(user);
			request.setAttribute("sessionUser", session);
			request.setAttribute("products list", productsList);
			request.getRequestDispatcher("./ProductsList.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
