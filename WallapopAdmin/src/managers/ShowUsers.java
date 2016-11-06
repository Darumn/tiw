package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUsers extends AdminManager {
	HttpServletRequest request;
	HttpServletResponse response;

	public ShowUsers(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("./admin.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}

	}

}
