package managers;
import model.*;
import logic.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProductManager extends Manager {

	public UpdateProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
		ProductManager manager=new ProductManager();
		try{
			List<Product> lista= manager.findAllProducts();
			this.request.setAttribute("product list", lista);
			request.getRequestDispatcher("./UpdateProducts.jsp").include(request, response);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	

}