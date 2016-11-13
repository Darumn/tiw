package managers;

import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.User;

public class ContactAdminList {
	public User usuario;
	public List<Message> mensajes;

	public ContactAdminList() {
		super();
		mensajes = new ArrayList<Message>();
	}

}
