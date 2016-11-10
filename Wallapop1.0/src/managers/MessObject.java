package managers;

import java.io.Serializable;

public class MessObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int senderId;
	private int receiverId;
	private String message;
	
	public MessObject(int senderId, int receiverId, String message) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*public ObjectMessage createObjectMessage(String destName,Serializable object) throws MessagingException {
	    JMSDestination jmsDest = getJMSDestination(destName);
	    try {
	        ObjectMessage message = jmsDest.session.createObjectMessage();
	        message.setObject(object);
	        return message;
	    } catch (JMSException e) {
	        throw new MessagingException(e.getMessage(), e);
	    }
	}*/
}
