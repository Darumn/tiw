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
		String id = request.getParameter("id");
		int idUser = Integer.parseInt(id);

		try {
			userOld = manager.findUserById(idUser);
//			ProductManager manager2 = new ProductManager();
			for (Product producto : userOld.getProducts()) {
				ProductManager p_manager = new ProductManager();
				p_manager.deleteProduct(producto);
			}
			List<Message> lista1=userOld.getMessages1();
			for (Message message : lista1) {
				MessageManager mensajemanager=new MessageManager();
				mensajemanager.deleteMessage(message);	
			}
			List<Message> lista2=userOld.getMessages2();
			for (Message message : lista2) {
				MessageManager mensajemanager=new MessageManager();
				mensajemanager.deleteMessage(message);	
			}
			
//			manager2.deleteAllById(userOld);
			manager = new UserManager();
			manager.deleteUser((userOld));
			manager = new UserManager();			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
