package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Manager {
	public HttpServletRequest request = null;
	HttpServletResponse response = null;
	public static final String CONST_SESSION = "CONST_SESSION";


	public Manager(HttpServletRequest pRequest, HttpServletResponse pResponse) {

		
		this.request = pRequest;
		this.response = pResponse;
		
	}

	public abstract void Execute();

}