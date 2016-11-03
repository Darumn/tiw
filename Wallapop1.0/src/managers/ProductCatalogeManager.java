package managers;

import model.*;
import logic.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductCatalogeManager extends Manager{

	public ProductCatalogeManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}
	
	public void Execute(){
		// TODO Auto-generated method stub
				String strid=this.request.getParameter("id");
				int id=Integer.parseInt(strid);
				ProductManager manager=new ProductManager();
				try{
					Product product= manager.findProductId(id);
					this.request.setAttribute("produtc", product);
					request.getRequestDispatcher("./index.jsp").forward(request, response);
				}
				catch(Exception e){
					
				}
	}

}
