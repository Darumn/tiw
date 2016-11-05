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
		System.out.println("Dentro del get no se");
		HttpSession session = request.getSession(true);
		System.out.println("Sesion localizadaaaaaaaaaaaaaa");
		String userID = String.valueOf(session.getAttribute(CONS_USERID));
		System.out.println("ID localizado "+ userID+ " sadkhshjadashjahsdjasdhjdaskjsda");
		if(userID != null){
			try{
				System.out.println("Antes del integer aprse int");
				int id = Integer.parseInt(userID);
				UserManager manager = new UserManager();
				System.out.println("antes de find user");
				ret = manager.findUserById(id);
				System.out.println("Todo OKOKOKOKOKOKOKOKO");
				
			}
			catch (Exception e){
				System.out.println("Esto");
			}
			
			
		}
		return ret;
		
	}
	
	public void setUser(User user){
		HttpSession session = this.request.getSession(true);
		session.setAttribute(CONS_USERID, user.getId());
	}

}
