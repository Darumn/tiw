package managers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;
import model.Product;
import model.User;

public class SearchAllProductsManager extends Manager {

	public SearchAllProductsManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	public void Execute() {
		
		Product producto = new Product();
		ProductManager manager = new ProductManager();
		
		

		try {
			List<Product> lista= manager.findAdvanced("arduino");
			
			request.setAttribute("product_list_advanced", lista);
			request.getRequestDispatcher("./Viewproductsseller.jsp").include(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

	}
}