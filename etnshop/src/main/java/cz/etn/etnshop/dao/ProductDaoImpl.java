package cz.etn.etnshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {


	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl() {
	}

	@Transactional
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		logger.info("Product successfully saved. Product details: " + product);
	}

	@Transactional
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		logger.info("Product successfully update. Product details: " + product);
	}

	@Transactional
	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(id));
		if (product != null) {
			session.delete(product);
		}

		logger.info("Product successfully removed. Product details: " + product);
	}

	@Transactional
	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product successfully loaded. Product details: " + product);
		return product;
	}

	@Transactional
	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList = session.createQuery("from Product").list();

		for (Object product : productList) {
			logger.info("Product list: " + product);
		}

		return productList;
	}

	@Transactional
	public void setSessionFactory(SessionFactory sessionFactory) {
	}
}
