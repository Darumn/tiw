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

		try {
			SessionAdminManager sessionUser = new SessionAdminManager(this.request, this.response);

			if (sessionUser.getUser() != null) {
				request.setAttribute("sessionUser", sessionUser);
			}
			
			productOld = manager.findProductById(idProduct);
			request.setAttribute("old product", productOld);
			request.getRequestDispatcher("./SelectEditProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
