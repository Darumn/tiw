package managers;

import model.*;
import logic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.ContactAdminList;

public class ChatRoomAdminManager extends AdminManager {

	public ChatRoomAdminManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

		MessageManager manager = new MessageManager();

		User user = new User();
		UserManager userManager2 = new UserManager();
		String id = request.getParameter("id");

		try {
			List<Message> lista = manager.findAllMessages(session.getUser().getId());

			List<ContactAdminList> listac = new ArrayList<ContactAdminList>();

			for (int i = 0; i < lista.size(); i++) {

				ContactAdminList item = null;

				for (int j = 0; j < listac.size() && item == null; j++) {
					if (listac.get(j).usuario.getId() == lista.get(i).getUser1().getId()) {
						item = listac.get(j);
					} else if (listac.get(j).usuario.getId() == lista.get(i).getUser2().getId()) {
						item = listac.get(j);
					}
				}

				if (item == null) {
					item = new ContactAdminList();
					if (lista.get(i).getUser1().getId() != this.session.getUser().getId()) {
						item.usuario = lista.get(i).getUser1();
					} else {
						item.usuario = lista.get(i).getUser2();
					}
					listac.add(item);
				}

				item.mensajes.add(lista.get(i));

			}

			user = userManager2.findUserById(Integer.parseInt(id));
			session.setUser(user);
			request.setAttribute("sessionUser", session);

			this.request.setAttribute("contact_list", listac);
			request.getRequestDispatcher("./ChatRoomAdmin.jsp").include(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				request.getRequestDispatcher("./login.jsp").include(request, response);
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
