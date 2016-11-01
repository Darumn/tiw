package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.UserManager;
import model.User;

public class SessionManager extends Manager{

	private final String CONS_USERID = "userID";
	
	
	public SessionManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stu
	}

	@Override
	public void Execute(){
		throw new UnsupportedOperationException();
		
	}
	
	public User getUser(){
		User ret = null;
		HttpSession session = this.request.getSession(true);
		String userID = (String)session.getAttribute(CONS_USERID);
		if(userID != null){
			try{
				int id = Integer.parseInt(userID);
				UserManager manager = new UserManager();
				//ret = manager.findById(id);
			}
			catch (Exception e){
				
			}
			
			
		}
		return ret;
		
	}
	
	public void setUser(User user){
		HttpSession session = this.request.getSession(true);
		session.setAttribute(CONS_USERID, user.getId());
	}

}
