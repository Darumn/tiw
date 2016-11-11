package managers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import logic.ProductManager;
import model.Category;
import model.Product;
import model.User;

public class UpdateProductManager extends Manager {

	public UpdateProductManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Execute() {		
		
		try{			
			Product producto = null;
			ProductManager manager = new ProductManager();
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			producto = manager.findProductById(id);
			String name = request.getParameter("name");
			String description = request.getParameter("descriptionproduct");			
			BigDecimal price = new BigDecimal(((String) request.getParameter("pricepproduct")));
			String status=request.getParameter("statusproduct");	
			if(name != null && !name.equals("")){
				producto.setName(name);
			}
			
			if(name != null && !name.equals("")){
				producto.setDescription(description);
			}
			if(name != null && !name.equals("")){
				producto.setPrice(price);
			}
			
			
			if(name != null && !name.equals("")){
				producto.setStatus(status);
			}		
			
			
			manager.updateProduct(producto);
			
			this.manageImage(producto);
			
			//request.setAttribute("user", usuario);
			//request.getRequestDispatcher("./PerfilUsuario.jsp").include(request, response);
		}
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
			 
		}
	}
	
	private void manageImage(Product producto) throws IOException, ServletException{
	
		Part filePart = request.getPart("image");
		if(filePart != null){
			
			
		    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		    InputStream fileContent = filePart.getInputStream();
		    
		    File file = new File(Manager.productDirectoryFullPath+"/"+producto.getId()+".jpg");

		    try {
		        Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    }
		    catch(IOException e){
		    	
		    	
		    }
		    
		}
	}
	
	public static String getUrlImage(Product producto){
		String ret = null;
		
		File file = new File(Manager.productDirectoryFullPath+"/"+producto.getId()+".jpg");
		if(file.exists()){
			ret = "./images"+productDirectory+"/"+producto.getId()+".jpg";
		}
		
		return ret;
	}

}