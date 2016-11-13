package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import logic.UserManager;
import model.User;

/**
 * Servlet Filter implementation class WallapopAdminFIlter
 */
@WebFilter("/WallapopAdminFIlter")
public class WallapopAdminFilter implements Filter {
	
	FilterConfig config;
   
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("SOY EL FILTRO SIIIIIIIIIIIIIIIIIIIIIIII **************");
		if(request.getParameter("redirect").equals("AdminLogin")){
			String password = request.getParameter(WallapopAdminFilter.getHash((String)request.getParameter("password"), "SHA-1"));
			UserManager manager = new UserManager();
			User admin = manager.findAdmin();
			String admin_pass = admin.getPassword();
			if(!password.equals(admin_pass)){
				RequestDispatcher reqDis =request.getRequestDispatcher("./login.jsp");
				reqDis.forward(request, response);
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SOY EL FILTRO INICIADO SIIIIIIIIIIIIIIIIIIIIIIII **************");
		this.config = config;
	}
	public static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
 
   
 
    
    public static String sha1(String txt) {
        return WallapopAdminFilter.getHash(txt, "SHA1");
    }
}
