package managers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
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
		int cat_id = -1;
		if(request.getParameter("search_category") != "") cat_id = Integer.parseInt((String)request.getParameter("search_category"));
		CategoryManager cat_manager = new CategoryManager();
		String city = ((String)request.getParameter("search_city")).toLowerCase();
		String seller = ((String) request.getParameter("search_seller")).toLowerCase();
		String title = ((String) request.getParameter("search_title")).toLowerCase();
		String description = ((String) request.getParameter("search_description")).toLowerCase();
		String status = ((String) request.getParameter("search_status")).toLowerCase();
		try {
			
			User user = new User();
			user.setName(seller);
			user.setCity(city);
			
			Category category = cat_manager.findCategoryById(cat_id);
			producto.setCategory(category);
			producto.setName(title);
			producto.setDescription(description);
			producto.setUser(user);
			producto.setStatus(status);
			
			
			List<Product> lista= manager.findAdvanced(producto);
			CategoryManager cat=new CategoryManager();
			List<Category> lista2=cat.findAll();
			request.setAttribute("product list", lista);
			request.setAttribute("category_list", lista2);
			request.getRequestDispatcher("./index.jsp").include(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				request.getRequestDispatcher("./index.jsp").include(request, response);
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