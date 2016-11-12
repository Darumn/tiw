package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.UserManager;
import model.User;

public class SessionAdminManager extends IManager{

	private final String CONS_USERID = "userID";
	
	
	public SessionAdminManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
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
			}
			
			
		}
		return ret;
		
	}
	
	public void setUser(User user){
		HttpSession session = this.request.getSession(true);
		session.setAttribute(CONS_USERID, user.getId());
	}

}

