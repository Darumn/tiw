package managers;
import model.*;
import logic.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

		if(idStr == null) idStr = String.valueOf(this.request.getAttribute("id"));

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