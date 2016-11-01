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
	
	public void findProduct(Product product) throws Exception{
		
		try{
			//Find user in login
			if(product.getId() == -1){
				Query query =em.createQuery("SELECT c FROM User c WHERE c.email = :varEmail AND c.password = :varPassword"); 
				query.setParameter("varName", product.getName());
				query.setParameter("varDescription", product.getDescription());
				query.setParameter("varPrice", product.getPrice());
				query.setParameter("varStatus", product.getStatus());
				product = (Product)query.getSingleResult();
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
