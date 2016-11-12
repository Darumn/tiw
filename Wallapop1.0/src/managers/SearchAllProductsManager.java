package managers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class SearchAllProductsManager extends Manager {

	public SearchAllProductsManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	public void Execute() {
		
		Product producto = new Product();
		ProductManager manager = new ProductManager();
		int cat_id = Integer.parseInt((String)request.getParameter("descriptionproduct"));
		CategoryManager cat_manager = new CategoryManager();
		String city = ((String)request.getParameter("search_city")).toLowerCase();
		String seller = ((String) request.getParameter("search_seller")).toLowerCase();
		String title = ((String) request.getParameter("search_title")).toLowerCase();
		String description = ((String) request.getParameter("search_description")).toLowerCase();
		try {
			
			User user = new User();
			user.setName(seller);
			user.setCity(city);
			
			Category category = cat_manager.findCategoryById(cat_id);
			producto.setCategory(category);
			producto.setName(title);
			producto.setDescription(description);
			producto.setUser(user);
			
			
			List<Product> lista= manager.findAdvanced(producto);
			
			request.setAttribute("product_list_advanced", lista);
			request.getRequestDispatcher("./Viewproductsseller.jsp").include(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

	}
}