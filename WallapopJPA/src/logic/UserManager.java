package logic;

import java.util.List;

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

	public void createUser(User user) throws Exception {
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

	public User findUser(User usuario) throws Exception {
		User ret = null;
		try {
			// Find user in login
			System.out.println("Valor del email **************** " + usuario.getEmail());
			if (usuario.getId() == -1) {
				Query query = em.createQuery("SELECT c FROM User c WHERE c.email = :varEmail ");
				// System.out.println("QUERY "+query.toString());
				query.setParameter("varEmail", usuario.getEmail());
				// usuario = (User)query.getResultList();
				List<User> lista = query.getResultList();
				if (lista != null && !lista.isEmpty()) {
					ret = (User) lista.get(0);
					System.out.println(ret.getName());
				} else {
					System.out.println("Lista vacia ***********");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public User findUserById(int id) throws Exception {
		User ret = null;
		try {

			Query query = em.createQuery("SELECT c FROM User c WHERE c.id = :varId ");
			// System.out.println("QUERY "+query.toString());
			ret = em.find(User.class, id);
			query.setParameter("varId", id);
			// usuario = (User)query.getResultList();
			List lista = query.getResultList();
			if (lista != null && !lista.isEmpty()) {
				ret = (User) lista.get(0);
				System.out.println(ret.getName());
			} else {
				System.out.println("Lista vacia ***********");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}
	
	//public UsersList<User> 
}
