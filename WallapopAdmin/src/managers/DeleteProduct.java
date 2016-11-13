package managers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class DeleteProduct extends AdminManager {

	public DeleteProduct(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		ProductManager manager = new ProductManager();
		Product productOld;
		String id = request.getParameter("id_object");
		int idProduct = Integer.parseInt(id);

		User user = new User();
		UserManager userManager = new UserManager();
		String id2 = request.getParameter("id");

		ProductManager products = new ProductManager();
		List<Product> productsList;

		try {
			productOld = manager.findProductById(idProduct);
			manager = new ProductManager();
			manager.deleteProduct(productOld);
			productsList = products.findAllProducts();
			user = userManager.findUserById(Integer.parseInt(id2));
			session.setUser(user);
			request.setAttribute("products list", productsList);
			request.setAttribute("sessionUser", session);
			request.getRequestDispatcher("./ProductsList.jsp").forward(request, response);
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
