package managers;

import model.*;
import logic.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAdminManager extends AdminManager {

	public IndexAdminManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

		ProductManager manager = new ProductManager();
		try {
			List<Product> lista = manager.findAllProducts();
			this.request.setAttribute("product list", lista);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}