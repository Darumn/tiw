package managers;

import model.*;
import logic.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductCatalogManager extends Manager{

	public ProductCatalogManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}
	
	public void Execute(){
		// TODO Auto-generated method stub
				int id=Integer.parseInt(this.request.getParameter("id"));
				ProductManager manager=new ProductManager();
				try{
					Product product= manager.findProductId(id);
					this.request.setAttribute("product", product);
					request.getRequestDispatcher("./Viewproductsseller.jsp").forward(request, response);
				}
				catch(Exception e){
					
				}
	}

}
