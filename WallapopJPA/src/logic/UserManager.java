package logic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.*;

public class UserManager {

	private EntityManagerFactory emf;
	public EntityManager em;
	
	public UserManager() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("WallapopJPA");
		this.em = this.emf.createEntityManager();
	}

	public UserManager(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	public String createUser(User user) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(user);
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
		return "";
	}
	public String deletePersona(User user) throws Exception {
		try {
			em.getTransaction().begin();
			user = em.merge(user);
			em.remove(user);
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
		return "";
	}

	public String updatePersona(User user) throws Exception {
		try {
			em.getTransaction().begin();
			user = em.merge(user);
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
		return "";
	}
	
	public User findUser(String usuario, String pass) throws Exception{
		
		User user = null;
		
		try{
			Query query =em.createQuery("SELECT c FROM User c WHERE c.email = :varEmail AND c.password = :varPassword"); 
			query.setParameter("varEmail", usuario);
			query.setParameter("varPassword", pass);
			user = (User)query.getSingleResult();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return user;
	}
}
