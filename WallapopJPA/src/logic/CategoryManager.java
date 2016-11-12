package logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Message;
import model.Product;
import model.Category;
import model.User;

@NamedQueries({ @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c "),})

public class CategoryManager {
	private EntityManagerFactory emf;
	public EntityManager em;

	public CategoryManager() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("WallapopJPA");
		this.em = this.emf.createEntityManager();
	}

	public CategoryManager(EntityManagerFactory emf) {
		this.emf = emf;
	}
	public List<Category> findAll() {
		List<Category> ret = null;
		try {
			Query query = em.createNamedQuery("Category.findAll", Category.class);
			ret = query.getResultList();

		} finally {
			em.close();
		}
		return ret;

	}
	public Category findCategoryById(int category) throws Exception {
		Category ret = null;

		try {
			// Query query =
			// em.createNamedQuery("Product.findById",Product.class);
			Query query = em.createQuery("SELECT c FROM Category c WHERE c.id = :varID ", Category.class);
			query.setParameter("varID", category);
			List<Category> list = query.getResultList();

			if (list != null && list.size() > 0) {
				ret = list.get(0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return ret;
	}
}
