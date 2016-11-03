package logic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.*;

public class ProductManager {

	private EntityManagerFactory emf;
	public EntityManager em;

	public ProductManager() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("WallapopJPA");
		this.em = this.emf.createEntityManager();
	}

	public ProductManager(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void createProduct(Product product) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(product);
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

	public String deleteProduct(Product product) throws Exception {
		try {
			em.getTransaction().begin();
			product = em.merge(product);
			em.remove(product);
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

	public String updateProduct(Product product) throws Exception {
		try {
			em.getTransaction().begin();
			product = em.merge(product);
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

	public void findAll() throws Exception {

		try {
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Product findProductId(int product) throws Exception {

		Product ret = null;
		try{
			ret = em.find(Product.class, product);
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return ret;
	}
}
