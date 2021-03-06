package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.UserManager;
import model.User;

public class SessionManager extends IManager{

	private final String CONS_USERID = "userID";
	
	
	public SessionManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stu
	}
	
	public User getUser(){
		User ret = null;
		HttpSession session = request.getSession(true);
		//SessionManager session =(SessionManager) request.getAttribute("session");
		String userID = String.valueOf(session.getAttribute(CONS_USERID));
		if(userID != null){
			try{
				int id = Integer.parseInt(userID);
				UserManager manager = new UserManager();
				ret = manager.findUserById(id);
				
			}
			catch (Exception e){
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
		return ret;
		
	}
	
	public void setUser(User user){
		HttpSession session = this.request.getSession(true);
		session.setAttribute(CONS_USERID, user.getId());
	}

}
