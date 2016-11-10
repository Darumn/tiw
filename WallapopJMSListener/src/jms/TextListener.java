package jms;

import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import managers.MessObject;

import javax.jms.JMSException;
import javax.jms.Message;

public class TextListener implements MessageListener {


    public void onMessage(Message message) {
      //  MessObject msg = null;

      
            if (message instanceof ObjectMessage) {
            	try {
					System.out.println(((MessObject)((ObjectMessage)message).getObject()).getMessage());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					System.out.println("Soy una excepcion");
					e.printStackTrace();
				}
            	//Object object = ((ObjectMessage) message).getObject();
            	//msg = (MessObject) object;
                //System.out.println("Lectura Asíncrona-->: " + msg.getMessage());
                //System.out.println(this.getClass().getName()
                //		+ "has received a message : " + (MessObject) object);
            } else {
                System.err.println("Message is not a TextMessage");
            }
       
    }
}

