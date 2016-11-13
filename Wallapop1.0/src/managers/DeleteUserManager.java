package managers;
import model.*;
import logic.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserManager extends Manager {

	public DeleteUserManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
		UserManager manager = new UserManager();
		User userOld;
		String id = request.getParameter("id");
		int idUser = Integer.parseInt(id);

		try {
			userOld = manager.findUserById(idUser);
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
			
			manager = new UserManager();
			manager.deleteUser((userOld));
			manager = new UserManager();			
						
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.getRequestDispatcher("./index.jsp").include(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}