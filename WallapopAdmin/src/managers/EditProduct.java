package managers;

import java.math.BigDecimal;
import java.util.List;

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
		try {
			oldProduct = manager.findProductById(idProduct);
			String name = request.getParameter("name");
			if (name != null) {
				newProduct.setName(name);
			}

			String price = request.getParameter("price");
			if (price != null) {
				BigDecimal finalPrice = new BigDecimal(price);
				newProduct.setPrice(finalPrice);
			}

			String status = request.getParameter("status");
			if (status != null) {
				newProduct.setStatus(status);
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
			}

			if (oldProduct.getCategory().getName().equals(finalCategory.getName())) {
				finalCategory.setProducts(oldProduct.getCategory().getProducts());
			} else {
				List<Product> categoryList = manager.findProductByCategory(String.valueOf(finalCategory.getId()));
				if (!categoryList.contains(newProduct)) {
					categoryList.add(newProduct);
				}
				finalCategory.setProducts(categoryList);
			}

			String description = request.getParameter("description");
			if (description != null) {
				newProduct.setDescription(description);
			}

			User userProduct = oldProduct.getUser();
			if (userProduct != null) {
				newProduct.setUser(userProduct);
			}

			newProduct.setCategory(finalCategory);

			try {
				SessionAdminManager sessionUser = new SessionAdminManager(this.request, this.response);

				if (sessionUser.getUser() != null) {
					request.setAttribute("sessionUser", sessionUser);
				}

				if (manager.updateProduct(oldProduct).equals("")) {
					request.getRequestDispatcher("./index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
