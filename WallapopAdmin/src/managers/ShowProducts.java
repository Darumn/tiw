package managers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

			user = userManager.findUserById(Integer.parseInt(id));
			session.setUser(user);
			request.setAttribute("sessionUser", session);
			request.setAttribute("products list", productsList);
			request.getRequestDispatcher("./ProductsList.jsp").forward(request, response);
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
