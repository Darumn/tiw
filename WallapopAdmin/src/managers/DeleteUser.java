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

			manager = new UserManager();
			manager.deleteUser(userOld);

			SessionAdminManager sessionUser = new SessionAdminManager(this.request, this.response);

			if (sessionUser.getUser() != null) {
				request.setAttribute("sessionUser", sessionUser);
			}

			request.getRequestDispatcher("./index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
