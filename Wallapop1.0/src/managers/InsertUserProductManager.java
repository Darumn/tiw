package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUserProductManager extends Manager{

	public InsertUserProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		try{
			this.request.getRequestDispatcher("./InsertProducts.jsp").include(this.request, this.response);
		}
		catch(Exception e){
			
		}
	}

}
