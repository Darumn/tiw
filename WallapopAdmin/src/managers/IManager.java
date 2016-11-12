package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class IManager {
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	
	public IManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		this.request = pRequest;
		this.response = pResponse;
	}
	
}
