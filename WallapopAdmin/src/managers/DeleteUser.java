package managers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

public class DeleteUser extends AdminManager {

	public DeleteUser(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		UserManager manager = new UserManager();
		User userOld;
		String id = request.getParameter("id_object");
		int idUser = Integer.parseInt(id);

		User user = new User();
		UserManager userManager = new UserManager();
		String id2 = request.getParameter("id");

		UserManager users;
		List<User> usersList;

		try {
			userOld = manager.findUserById(idUser);

			for (Product producto : userOld.getProducts()) {
				ProductManager p_manager = new ProductManager();
				p_manager.deleteProduct(producto);
			}

			List<Message> lista1 = userOld.getMessages1();
			for (Message message : lista1) {
				MessageManager mensajemanager = new MessageManager();
				mensajemanager.deleteMessage(message);
			}

			List<Message> lista2 = userOld.getMessages2();
			for (Message message : lista2) {
				MessageManager mensajemanager = new MessageManager();
				mensajemanager.deleteMessage(message);
			}

			users = new UserManager();
			manager = new UserManager();
			if (manager.deleteUser(userOld).equals("")) {
				usersList = users.showUsers();
				user = userManager.findUserById(Integer.parseInt(id2));
				session.setUser(user);
				request.setAttribute("users list", usersList);
				request.setAttribute("sessionUser", session);
				request.getRequestDispatcher("./UsersList.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
