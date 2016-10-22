package wall10.serv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class ProcesarFormulario
 */
@WebServlet("/ProcesarFormulario")
public class ProcesarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesarFormulario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean validateEmail(String email) {

		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	public void fallo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r = request.getRequestDispatcher("ProcesarFormulario.jsp");
		HttpSession session = request.getSession(true);

		r.forward(request, response);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		if (!validateEmail(email)) {
			fallo(request, response);
		}

		String email2 = request.getParameter("email2");
		if (!email2.equals(email)) {
			fallo(request, response);
		}

		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		if (!pass.equals(pass2)) {
			fallo(request, response);
		}

		String name = request.getParameter("name");
		if (name == null || name.length() == 0) {
			fallo(request, response);
		}

		String surname = request.getParameter("surname");
		if (surname == null || surname.length() == 0) {
			fallo(request, response);
		}

		// conexion con bbdd

		RequestDispatcher r = request.getRequestDispatcher("PerfilUsuario.jsp");
		HttpSession session = request.getSession(true);

		r.forward(request, response);
		doGet(request, response);
	}

}
