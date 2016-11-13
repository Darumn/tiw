package managers;

import model.*;
import logic.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchManager extends Manager {

	public SearchManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		List<Product> list = null;
		try {
			String category = (String) request.getParameter("search_input");
			ProductManager manager = new ProductManager();
			list = manager.findProductByCategory(category.toLowerCase());
			
			CategoryManager cat=new CategoryManager();
			List<Category> cat_list=cat.findAll();
			this.request.setAttribute("category_list", cat_list);
			request.setAttribute("product list", list);
			request.getRequestDispatcher("./index.jsp").include(request, response);
		} catch (Exception e) {
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
