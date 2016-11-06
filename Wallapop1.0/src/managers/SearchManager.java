package managers;
import model.*;
import logic.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchManager extends Manager {

	public SearchManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		try{
			System.out.println("Entramos en el seacrh");
			String category = (String)request.getAttribute("explorer_input");
			ProductManager manager = new ProductManager();
			System.out.println("vamos a realziar la busqueda");
			List<Product> list = manager.findProductByCategory(category.toLowerCase());
			for (Product product : list) {
				System.out.println("Producto "+ product.getName());
			}
			request.setAttribute("product list", list);

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
