package managers;
import model.*;
import logic.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewUpdateProductManager extends Manager {

	public ViewUpdateProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
		String idStr = this.request.getParameter("id");
		int id = Integer.parseInt(idStr);
		ProductManager manager = new ProductManager();
		try{
			Product product= manager.findProductById(id);
			CategoryManager cat=new CategoryManager();
			List<Category> lista=cat.findAll();
			this.request.setAttribute("category_list", lista);
			this.request.setAttribute("product", product);
			request.getRequestDispatcher("./UpdateProducts.jsp").include(request, response);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	

}