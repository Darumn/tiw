package jms;

import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Message;
//import javax.jms.TextMessage;
import jms.MessObject;

public class TextListener implements MessageListener {


    public void onMessage(Message message) {
        MessObject msg = null;

        try {
            if (message instanceof ObjectMessage) {
            	Object object = ((ObjectMessage) message).getObject();
            	//msg = (MessObject) object;
                //System.out.println("Lectura Asíncrona-->: " + msg.getMessage());
                //System.out.println(this.getClass().getName()
                //		+ "has received a message : " + (MessObject) object);
            } else {
                System.err.println("Message is not a TextMessage");
            }
        } catch (Throwable t) {
            System.err.println("Exception in onMessage():" + t.getMessage());
        }
    }
}

