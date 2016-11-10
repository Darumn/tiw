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
		try {
			productsList = products.findAllProducts();
			request.setAttribute("products list", productsList);
			request.getRequestDispatcher("./ProductsList.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
