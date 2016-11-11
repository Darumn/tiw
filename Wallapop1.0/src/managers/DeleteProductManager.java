package managers;
import model.*;
import logic.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProductManager extends Manager {

	public DeleteProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
		ProductManager manager=new ProductManager();
		try{
			String idStr = this.request.getParameter("id");
			int id = Integer.parseInt(idStr);
			Product product = manager.findProductById(id);
			manager = new ProductManager();
			manager.deleteProduct(product);
			
			manager = new ProductManager();
			
			List<Product> lista= manager.findAllProducts();
			this.request.setAttribute("product list", lista);
			
			request.getRequestDispatcher("./index.jsp").include(request, response);
		}
		catch(Exception e){
			//throw new PetadoTotalException();
			System.out.println(e.getStackTrace());
		}
	}
	
	
	

}