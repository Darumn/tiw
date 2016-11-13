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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import managers.*;
import model.*;

/**
 * Servlet Filter implementation class WallapopAdminFIlter
 */
@WebFilter("/WallapopAdminFilter")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String action = request.getParameter("redirect");
		if (action != null) {
			if (action.equals("AdminLogin")) {
				String password = WallapopAdminFilter.getHash((String) request.getParameter("password"), "SHA-1");
				UserManager manager = new UserManager();
				User admin = manager.findAdmin();
				String admin_pass = admin.getPassword();
				if (!password.equals(admin_pass)) {
					RequestDispatcher reqDis = request.getRequestDispatcher("./login.jsp");
					reqDis.forward(request, response);
				}
			} else {
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse rep = (HttpServletResponse) response;

				SessionAdminManager sessionUser = new SessionAdminManager(req, rep);

				if (sessionUser == null) {
					RequestDispatcher reqDis = request.getRequestDispatcher("./login.jsp");
					reqDis.forward(request, response);
				} else {
					if (sessionUser.getUser() == null) {
						RequestDispatcher reqDis = request.getRequestDispatcher("./login.jsp");
						reqDis.forward(request, response);
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

	public static String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
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
