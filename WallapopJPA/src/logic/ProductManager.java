package logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.*;

@NamedQueries({
	@NamedQuery(name = "Product.findAll", query = "SELECT c FROM product c "),
	@NamedQuery(name = "Product.findById", query = "SELECT c FROM product c WHERE c.id = :varID "),
	})

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

	public List<Product> findAllProducts() {
		List<Product> ret=null;
		try {
			
			Query query = em.createNamedQuery("Product.findAll",Product.class);
			
			
			ret = query.getResultList();
			
		} finally {
			em.close();
		}
		return ret;

	}
	public Product findProductById(int product) throws Exception {
		Product ret=null;
		
		try{
			//Query query = em.createNamedQuery("Product.findById",Product.class);
			Query query = em.createQuery("SELECT c FROM Product c WHERE c.id = :varID ",Product.class);
			query.setParameter("varId", product);
			
			List<Product> list = query.getResultList();
			
			if(list!=null && list.size()>0){
				ret = list.get(0);
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		return ret;
	}
}
