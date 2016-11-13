package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.UserManager;
import model.User;

public class ReturnIndex extends AdminManager {

	public ReturnIndex(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		User user = new User();
		UserManager userManager2 = new UserManager();
		String id = request.getParameter("id");

		try {
			user = userManager2.findUserById(Integer.parseInt(id));
			session.setUser(user);
			request.setAttribute("sessionUser", session);
			request.getRequestDispatcher("./indexAdmin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
