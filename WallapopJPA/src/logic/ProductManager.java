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
	@NamedQuery(name = "Product.findAll", query = "SELECT c FROM product c "), })

public class ProductManager {
	private String _unidadPersistencia;
	private EntityManagerFactory emf;
	public EntityManager em;
	private List<Product> _listaProductos = null;

	public ProductManager() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("WallapopJPA");
		this.em = this.emf.createEntityManager();
	}

	public ProductManager(EntityManagerFactory emf) {
		this.emf = emf;
	}
	private void proxyCreateEntityManager() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(_unidadPersistencia);

		this.em = factory.createEntityManager();

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

		try {
			proxyCreateEntityManager();
			Query query = em.createNamedQuery("Product.findAll",Product.class);
			
			
			_listaProductos = query.getResultList();
			
		} finally {
			em.close();
		}
		return _listaProductos;

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
