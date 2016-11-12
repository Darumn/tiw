package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import logic.CategoryManager;
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
		}
	}

}
