package managers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.UserManager;
import model.Product;
import model.User;

public class UserProductsManager extends Manager {

	public UserProductsManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		String strId = this.request.getParameter("id");
		int id = Integer.parseInt(strId);
		User user = null;
		try{
			UserManager manager = new UserManager();
			user = manager.findUserById(id);
			List<Product> products = user.getProducts();
			
			this.request.setAttribute("mensaje", "Productos del usuario " + user.getName() + " " + user.getSurname());
			this.request.setAttribute("product list", products);
			request.getRequestDispatcher("./Viewproductsseller.jsp").include(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
