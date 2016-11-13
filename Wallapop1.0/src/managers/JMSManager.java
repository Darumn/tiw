package managers;

import java.io.IOException;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

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

			User user = session.getUser();
			MessObject obj = new MessObject(user.getId(), Integer.parseInt(request.getParameter("receiver_id")), request.getParameter("message"));
			ObjectMessage mess =  QSes.createObjectMessage(obj);
			
			Qcon.start();
			Mpro.send(mess);

			this.Mpro.close();
			this.QSes.close();
			this.Qcon.close();
			
		}catch (Exception e){
			System.out.println("En el envio de mensaje");
			System.out.println(e.getStackTrace());
			try {
				request.getRequestDispatcher("./index.jsp").include(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 

	}
}
