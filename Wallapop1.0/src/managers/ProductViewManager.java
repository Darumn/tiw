package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ProductManager;
import logic.UserManager;
import model.Product;

public class ProductViewManager extends Manager {

	public ProductViewManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		
		String idStr = this.request.getParameter("id");
		int id = Integer.parseInt(idStr);
		ProductManager manager = new ProductManager();
		try{
			Product product= manager.findProductById(id);
			this.request.setAttribute("product", product);
			request.getRequestDispatcher("./ProductView.jsp").include(request, response);
		}
		catch(Exception e){
			
		}
	}

}
