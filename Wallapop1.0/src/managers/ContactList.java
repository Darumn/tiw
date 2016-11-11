package managers;

import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.User;

public class ContactList {
	public User usuario;
	public List<Message> mensajes;
	public ContactList() {
		super();
		mensajes = new ArrayList<Message>();
	}
	
}
