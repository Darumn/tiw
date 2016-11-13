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

			// Cambiar a switch
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

			String category = request.getParameter("category");
			Category finalCategory = new Category();
			if (category != null) {
				switch (category) {
				case "coche":
					finalCategory.setId(1);
					finalCategory.setName("coche");
					break;
				case "copa":
					finalCategory.setId(2);
					finalCategory.setName("copa");
					break;
				case "electronica":
					finalCategory.setId(3);
					finalCategory.setName("electronica");
					break;
				case "otros":
					finalCategory.setId(4);
					finalCategory.setName("otros");
					break;
				}
			} else {
				newProduct.setCategory(oldProduct.getCategory());
			}

			if (oldProduct.getCategory().getName().equals(finalCategory.getName())) {
				finalCategory.setProducts(oldProduct.getCategory().getProducts());
			} else {
				manager = new ProductManager();
				List<Product> categoryList = manager.findProductByCategory(String.valueOf(finalCategory.getId()));
				if (!categoryList.contains(newProduct)) {
					categoryList.add(newProduct);
				}
				finalCategory.setProducts(categoryList);
			}

			newProduct.setCategory(finalCategory);

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
