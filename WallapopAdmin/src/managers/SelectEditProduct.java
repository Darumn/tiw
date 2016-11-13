package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class SelectEditProduct extends AdminManager {

	public SelectEditProduct(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		ProductManager manager = new ProductManager();
		Product productOld;
		String id = request.getParameter("id_object");
		int idProduct = Integer.parseInt(id);

		User user = new User();
		UserManager userManager = new UserManager();
		String id2 = request.getParameter("id");

		try {
			user = userManager.findUserById(Integer.parseInt(id2));
			session.setUser(user);
			request.setAttribute("sessionUser", session);

			productOld = manager.findProductById(idProduct);
			request.setAttribute("old product", productOld);
			request.getRequestDispatcher("./SelectEditProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
