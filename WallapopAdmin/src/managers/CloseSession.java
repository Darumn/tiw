package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CloseSession extends AdminManager {

	public CloseSession(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		HttpSession session = request.getSession();
		session.invalidate();
		try {
			request.getRequestDispatcher("./login.jsp").include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
