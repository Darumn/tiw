package logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Message;
import model.Product;;

public class MessageManager {
	private EntityManagerFactory emf;
	public EntityManager em;

	public MessageManager() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("WallapopJPA");
		this.em = this.emf.createEntityManager();
	}

	public MessageManager(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void createMessage(Message message) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(message);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
	}
	
	public List<Message> findAllMessages(int id){
		List<Message> ret = null;
		
		try {
			Query query = em.createQuery("SELECT c FROM Message c WHERE c.user1.id = :varID OR c.user2.id = :varID  ", Message.class);
			query.setParameter("varID", id);
			ret = query.getResultList();

		} finally {
			em.close();
		}
		return ret;
	}
}
