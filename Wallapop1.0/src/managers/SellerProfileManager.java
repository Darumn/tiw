package managers;
import model.*;
import logic.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SellerProfileManager extends Manager {

	public SellerProfileManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		try{
			String strId = request.getParameter("seller_id");
			int id = Integer.parseInt(strId);
			UserManager manager = new UserManager();
			User seller = manager.findUserById(id);
			request.setAttribute("user", seller);
			request.getRequestDispatcher("./SellerProfile.jsp").include(request, response);

		}
		catch(Exception e){
			System.out.println(e.getMessage());
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
