
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
@MultipartConfig(maxFileSize = 16177215) 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean initilized = false;
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Controller() {
		super();
		
		/*if(!initilized){
			initProperties();
		}*/
	}

	public void service(HttpServletRequest request, HttpServletResponse response){
		if(!initilized){
			initProperties();
		}
		
		try {
			doGet(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initProperties() {
		ServletContext servletContext = getServletContext();
		Manager.path = servletContext.getRealPath("/images");
		//Manager.path = "/home/tiw/git/wallapop2.git/tiw/Wallapop1.0/WebContent/images";
		
		Manager.userDirectoryFullPath = Manager.path+Manager.userDirectory;
		
		File file = new File(Manager.userDirectoryFullPath);
		if(!file.exists()){
			file.mkdir();
		}
		
		Manager.productDirectoryFullPath = Manager.path+Manager.productDirectory;
		
		file = new File(Manager.productDirectoryFullPath);
		if(!file.exists()){
			file.mkdir();
		}
		
		initilized = true;
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String action = request.getParameter("redirect");

		// HttpSession session = request.getSession(true);

		Manager manager = null;

		if (action != null && !action.equals("")) {

			if (action.equals("Login")) {
				manager = new LoginManager(request, response);
				manager.Execute();
				if(request.getAttribute("session") != null) {
					manager = new IndexManager(request, response);
				}
				else{
					manager = new FormularioManager(request, response);
				}
				//request.getRequestDispatcher("./index.jsp").forward(request, response);

			} else if (action.equals("RegisterUserManager")) {
				manager = new RegisterUserManager(request, response);
				manager.Execute();
				manager = new IndexManager(request, response);
				

			} else if (action.equals("RegisterProductManager")) {
				manager = new RegisterProductManager(request, response);
				manager.Execute();
				manager = new UserProductsManager(request, response);

			} else if (action.equals("UserProfile")) {
				manager = new UserProfileManager(request, response);

			} else if (action.equals("ProductCatalog")) {
				manager = new ProductCatalogManager(request, response);
				
			} else if (action.equals("Product")) {
				manager = new ProductViewManager(request, response);
				
			} else if (action.equals("Formulario")) {
				manager = new FormularioManager(request, response);
				
			} else if (action.equals("modificarUsuario")){
				manager = new UserUpdateManager(request, response);
				manager.Execute();
				manager = new UserProfileManager(request, response);
			}else if(action.equals("eliminarUsuario")){
				manager = new DeleteUserManager(request,response);
				manager.Execute();
				request.getSession(true).invalidate();
				manager = new IndexManager(request, response);
			}else if (action.equals("UserProducts")) {
				manager = new UserProductsManager(request, response);
				
			} else if(action.equals("invalidateSession")){
				request.getSession(true).invalidate();
				manager = new IndexManager(request, response);
			}else if(action.equals("searchProducts")){
				manager = new SearchManager(request, response);
			}
			else if(action.equals("SellerProfile")){
				manager = new SellerProfileManager(request, response);
			}
			else if(action.equals("sendMessage")){
				manager = new JMSManager(request, response);
				manager.Execute();
				manager = new ChatRoomManager(request,response);
			}
			else if(action.equals("insertproduct")){
				manager = new InsertUserProductManager(request,response);
			}
			else if(action.equals("searchAllProducts")){
				manager = new SearchAllProductsManager(request,response);
			}
			else if(action.equals("chatRoom")){
				manager = new ChatRoomManager(request,response);
			}
			else if(action.equals("modificarproductousuario")){
				manager= new UpdateProductManager(request,response);
				manager.Execute();
				manager = new ViewUpdateProductManager(request, response);
			}
			else if(action.equals("viewUpdateProduct")){
				manager= new ViewUpdateProductManager(request,response);
			}
			else if(action.equals("DeleteProduct")){
				manager= new DeleteProductManager(request,response);
				manager.Execute();
				manager = new IndexManager(request, response);
			}
		}
		// Caso de index
		else {
			manager = new IndexManager(request, response);
			
		}
		
		request.getRequestDispatcher("./includes/header.jsp").include(request, response);
		manager.Execute();
		request.getRequestDispatcher("./includes/footer.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
