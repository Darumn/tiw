package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.UserManager;
import model.User;

public class EditUser extends AdminManager {

	public EditUser(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
	}

	@Override
	public void Execute() {
		UserManager manager = new UserManager();
		User newUser = new User();

		String id = request.getParameter("oldId");
		newUser.setId(Integer.parseInt(id));

		String name = (String) request.getParameter("name");
		if (name != null) {
			System.out.println("NAME: " + name);
			newUser.setName(name);
		}

		String surname = (String) request.getParameter("surname");
		if (surname != null) {
			System.out.println("SURNAME: " + surname);
			newUser.setSurname(surname);
		}

		String email = (String) request.getParameter("email");
		if (email != null) {
			System.out.println("EMAIL: " + email);
			newUser.setEmail(email);
		}

		String password = (String) request.getParameter("password");
		if (password != null) {
			System.out.println("PASSWORD: " + password);
			newUser.setPassword(password);
		}

		String city = (String) request.getParameter("city");
		if (city != null) {
			System.out.println("CITY: " + city);
			newUser.setCity(city);
		}

		try {
			if (manager.updatePersona(newUser).equals("")) {
				request.getRequestDispatcher("./index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
