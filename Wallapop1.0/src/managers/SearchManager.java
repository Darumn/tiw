package managers;

import model.*;
import logic.*;

import java.util.List;

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
			request.setAttribute("product list", list);
			request.getRequestDispatcher("./index.jsp").include(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
