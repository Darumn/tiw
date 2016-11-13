package managers;

import java.io.IOException;

import javax.servlet.ServletException;
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

		User user = new User();
		UserManager userManager = new UserManager();
		String id2 = request.getParameter("id");

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

			String password = EditUser.getHash((String) request.getParameter("password"), "SHA-1");
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

			newUser.setIsAdmin(oldUser.getIsAdmin());

			try {
				manager = new UserManager();

				if (manager.updatePersona(newUser).equals("")) {
					user = userManager.findUserById(Integer.parseInt(id2));
					session.setUser(user);
					request.setAttribute("sessionUser", session);
					request.setAttribute("old user", newUser);
					request.getRequestDispatcher("./SelectEditUser.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("./login.jsp").include(request, response);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				request.getRequestDispatcher("./login.jsp").include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String getHash(String password, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
			byte[] array = md.digest(password.getBytes());
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
		return EditUser.getHash(txt, "SHA1");
	}

}
