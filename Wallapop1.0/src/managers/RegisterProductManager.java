package managers;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;
import model.Product;
import model.User;

public class RegisterProductManager extends Manager {

	public RegisterProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	public void Execute() {
		Product producto = new Product();
		ProductManager manager = new ProductManager();
		producto.setDescription(((String) request.getParameter("descriptionproduct")));
		producto.setName(((String) request.getParameter("productname")));
		BigDecimal price = new BigDecimal(((String) request.getParameter("pricepproduct")));
		producto.setPrice(price);
		producto.setStatus(((String) request.getParameter("statusproduct")));
		Category catproducto = new Category();
		int catprod = Integer.parseInt((((String) request.getParameter("idcategory"))));
		catproducto.setId(catprod);
		catproducto.setName("electronica");
		producto.setCategory(catproducto);
		//User userproduct = new User();
		User user = session.getUser();
		
		producto.setUser(user);

		try {
			manager.createProduct(producto);
			request.setAttribute("product", producto);
			request.getRequestDispatcher("./index.jsp").include(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

	}
}