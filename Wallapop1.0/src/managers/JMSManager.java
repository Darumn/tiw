package managers;

import java.util.Enumeration;

import javax.jms.ObjectMessage;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JMSManager extends Manager{

	public JMSManager(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		super(pRequest, pResponse);
		// TODO Auto-generated constructor stub
	}


	//private javax.jms.ConnectionFactory factory = null;
	private javax.naming.InitialContext contextoInicial = null;
	//private javax.jms.Destination cola = null;
	private javax.jms.Connection Qcon = null;
	private javax.jms.Session QSes = null;
	private javax.jms.MessageProducer Mpro = null;
	private javax.jms.MessageConsumer Mcon = null;
	//private javax.jms.TopicConnection Tcon;
	
	@Resource(mappedName = "jms/wallapop")
	private javax.jms.ConnectionFactory factory;
	@Resource(mappedName = "jms/wallaqueue")
	private javax.jms.Destination cola;
	
	public void Execute() {

		String strQCF = "jms/wallafactory";
		String strQueueAsync = "jms/wallaqueue";
		
		try{
			contextoInicial = new javax.naming.InitialContext();

			factory = (javax.jms.ConnectionFactory) contextoInicial.lookup(strQCF);
			cola = (javax.jms.Destination) contextoInicial.lookup(strQueueAsync);

			Qcon = factory.createConnection();
			QSes = Qcon.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);

			Mpro = QSes.createProducer(cola);

			MessObject obj = new MessObject(1, 2, "Esto es un texto de prueba");
			ObjectMessage mess =  QSes.createObjectMessage();
			mess.setObject(obj);
			//javax.jms.TextMessage men = QSes.createTextMessage();

			//men.setText(mensaje);
			//men.setJMSCorrelationID(selector);
			Qcon.start();
			Mpro.send(mess);

			this.Mpro.close();
			this.QSes.close();
			this.Qcon.close();
			
		}catch (Exception e){
			System.out.println("En el envio de mensaje");
			System.out.println(e.getMessage());
		}
		 

	}
}
