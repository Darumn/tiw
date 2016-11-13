package managers;
import model.*;
import logic.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexManager extends Manager {

	public IndexManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
		ProductManager manager=new ProductManager();
		try{
			CategoryManager cat=new CategoryManager();
			List<Category> cat_list=cat.findAll();
			this.request.setAttribute("category_list", cat_list);
			List<Product> lista= manager.findAllProducts();
			this.request.setAttribute("product list", lista);
			request.getRequestDispatcher("./index.jsp").include(request, response);
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