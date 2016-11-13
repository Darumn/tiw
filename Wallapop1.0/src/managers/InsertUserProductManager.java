package managers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import logic.CategoryManager;

import java.io.IOException;
import java.util.List;
public class InsertUserProductManager extends Manager{

	public InsertUserProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {
		try{
			CategoryManager cat=new CategoryManager();
			List<Category> lista=cat.findAll();
			this.request.setAttribute("category_list", lista);
			this.request.getRequestDispatcher("./InsertProducts.jsp").include(this.request, this.response);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			try {
				request.getRequestDispatcher("./index.jsp").include(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
