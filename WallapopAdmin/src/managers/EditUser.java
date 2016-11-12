package managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import model.*;

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

		User oldUser;
		try {
			oldUser = manager.findUserById(Integer.parseInt(id));
			String name = (String) request.getParameter("name");
			System.out.println("NAME: " + name.length());
			if (name != null && name.length() != 0) {
				System.out.println("NAME: " + name);
				newUser.setName(name);
			} else {
				newUser.setName(oldUser.getName());
			}

			String surname = (String) request.getParameter("surname");
			System.out.println("SURNAME: " + surname.length());
			if (surname != null && surname.length() != 0) {
				System.out.println("SURNAME: " + surname);
				newUser.setSurname(surname);
			} else {
				newUser.setSurname(oldUser.getSurname());
			}

			String email = (String) request.getParameter("email");
			if (email != null && email.length() != 0) {
				System.out.println("EMAIL: " + email);
				newUser.setEmail(email);
			} else {
				newUser.setEmail(oldUser.getEmail());
			}

			String password = (String) request.getParameter("password");
			if (password != null && password.length() != 0) {
				System.out.println("PASSWORD: " + password);
				newUser.setPassword(password);
			} else {
				newUser.setPassword(oldUser.getPassword());
			}

			String city = (String) request.getParameter("city");
			if (city != null && city.length() != 0) {
				System.out.println("CITY: " + city);
				newUser.setCity(city);
			} else {
				newUser.setCity(oldUser.getCity());
			}

			try {
				SessionAdminManager sessionUser = new SessionAdminManager(this.request, this.response);

				if (sessionUser.getUser() != null) {
					request.setAttribute("sessionUser", sessionUser);
				}

				manager = new UserManager();

				if (manager.updatePersona(newUser).equals("")) {
					request.setAttribute("old user", newUser);
					request.getRequestDispatcher("./SelectEditUser.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
