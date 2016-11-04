package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Manager {
	HttpServletRequest request = null;
	HttpServletResponse response = null;

	public Manager(HttpServletRequest pRequest, HttpServletResponse pResponse) {

		this.request = pRequest;
		this.response = pResponse;

	}

	public abstract void Execute();

}
