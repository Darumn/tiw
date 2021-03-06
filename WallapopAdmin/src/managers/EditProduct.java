package managers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class EditProduct extends AdminManager {

	public EditProduct(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		ProductManager manager = new ProductManager();
		Product newProduct = new Product();

		String id = request.getParameter("oldId");
		int idProduct = Integer.parseInt(id);
		newProduct.setId(idProduct);

		Product oldProduct = new Product();

		User user = new User();
		UserManager userManager = new UserManager();
		String id2 = request.getParameter("id");

		try {
			oldProduct = manager.findProductById(idProduct);
			String name = request.getParameter("name");
			if (name != null && name.length() != 0) {
				newProduct.setName(name);
			} else {
				newProduct.setName(oldProduct.getName());
			}

			String price = request.getParameter("price");
			if (price != null && price.length() != 0) {
				BigDecimal finalPrice = new BigDecimal(price);
				newProduct.setPrice(finalPrice);
			} else {
				newProduct.setPrice(oldProduct.getPrice());
			}

			String status = request.getParameter("status");
			if (status != null && status.length() != 0) {
				switch (status) {
				case "disponible":
				case "reservado":
				case "vendido":
					newProduct.setStatus(status);
					break;
				}

			} else {
				newProduct.setStatus(oldProduct.getStatus());
			}

			String categoryId = request.getParameter("category");
			CategoryManager catManager = new CategoryManager();
			Category category = catManager.findCategoryById(Integer.parseInt(categoryId));

			if (category != null) {
				newProduct.setCategory(category);
			} else {
				newProduct.setCategory(oldProduct.getCategory());
			}

			String description = request.getParameter("description");
			if (description != null && description.length() != 0) {
				newProduct.setDescription(description);
			} else {
				newProduct.setDescription(oldProduct.getDescription());
			}

			User userProduct = oldProduct.getUser();
			if (userProduct != null) {
				newProduct.setUser(userProduct);
			} else {
				newProduct.setUser(oldProduct.getUser());
			}

			try {
				manager = new ProductManager();

				if (manager.updateProduct(newProduct).equals("")) {
					user = userManager.findUserById(Integer.parseInt(id2));
					session.setUser(user);
					request.setAttribute("sessionUser", session);
					request.setAttribute("old product", newProduct);
					request.getRequestDispatcher("./SelectEditProduct.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("./login.jsp").include(request, response);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				request.getRequestDispatcher("./login.jsp").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
