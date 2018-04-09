package cz.etn.etnshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.dao.ProductDao;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public ProductServiceImpl() {
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		this.productDao.addProduct(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		this.productDao.updateProduct(product);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
		this.productDao.removeProduct(id);
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return this.productDao.getProductById(id);
	}

	@Override
	@Transactional
	public List<Product> listProducts() {
		return this.productDao.listProducts();
	}
}
