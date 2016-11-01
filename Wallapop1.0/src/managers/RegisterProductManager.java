package managers;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class RegisterProductManager extends Manager{
	
	public RegisterProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}
	
	public void Execute(){
		Product producto=new Product();
		ProductManager manager=new ProductManager();
		int idprod=Integer.parseInt(((String)request.getParameter("statusproduct")));
		producto.setId(idprod);
		producto.setDescription(((String)request.getParameter("descriptionproduct")));
		producto.setName(((String)request.getParameter("productname")));
		BigDecimal price=new BigDecimal(((String)request.getParameter("pricepproduct")));
		producto.setPrice(price);
		producto.setStatus(((String)request.getParameter("statusproduct")));
		Category catproducto=new Category();
		int catprod=Integer.parseInt((((String)request.getParameter("statusproduct"))));
		catproducto.setId(catprod);
		User userproduct=new User();
		int iduser=Integer.parseInt((((String)request.getParameter("iduser"))));
		userproduct.setId(((iduser)));
		
		try{
			manager.createProduct(producto);
			request.setAttribute("product", producto);
			
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
			 
		}
		
		
	}
}