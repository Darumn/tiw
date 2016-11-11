package jms;

import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import managers.MessObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jms.JMSException;
import javax.jms.Message;
import logic.MessageManager;
import logic.UserManager;


public class TextListener implements MessageListener {


    public void onMessage(Message message) {
      //  MessObject msg = null;

      
            if (message instanceof ObjectMessage) {
            	try {
            		MessObject msg = (MessObject)((ObjectMessage)message).getObject();
            		model.Message mensaje = new model.Message();
            		
            		//message date
            		//DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            		
                    Date myDate = new Date();
                    SimpleDateFormat dayFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                    
            		mensaje.setDate(dayFormat.format(myDate));
            		
            		//message info
            		mensaje.setMessage(msg.getMessage());
            		mensaje.setUser1(new UserManager().findUserById(msg.getSenderId()));
            		mensaje.setUser2(new UserManager().findUserById(msg.getReceiverId()));
            		mensaje.setMessagecol("no se que va a aqui");
            		MessageManager manager = new MessageManager();
            		manager.createMessage(mensaje);
            	
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
            	catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else {
                System.err.println("Message is not a TextMessage");
            }
       
    }
}

