package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Manager {
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	SessionManager session = null;
	
	public Manager(HttpServletRequest pRequest, HttpServletResponse pResponse){
		
		this.request = pRequest;
		this.response = pResponse;
		this.session = new SessionManager(pRequest, pResponse);
	}

	public abstract void Execute();
	
}
