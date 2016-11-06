package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Manager extends IManager {
	
	public static final String CONST_SESSION = "CONST_SESSION";
	
	SessionManager session = null;
	

	public Manager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		
		if(this.session==null){
			this.session = new SessionManager(pRequest, pResponse);
			this.request.setAttribute(CONST_SESSION, this.session);
		}
	}

	public abstract void Execute();

}
