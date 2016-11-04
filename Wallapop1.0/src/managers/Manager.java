package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Manager {
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	// HEAD

	/*
	 * public Manager(HttpServletRequest pRequest, HttpServletResponse
	 * pResponse) {
	 * 
	 * SessionManager session = null; }
	 */

	public Manager(HttpServletRequest pRequest, HttpServletResponse pResponse) {

		// branch "master" of https://github.com/Darumn/tiw
		this.request = pRequest;
		this.response = pResponse;
		// HEAD

		// this.session = new SessionManager(pRequest, pResponse);
		// branch 'master' of https://github.com/Darumn/tiw
	}

	public abstract void Execute();

}
