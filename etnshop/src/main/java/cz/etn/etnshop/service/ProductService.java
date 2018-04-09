package cz.etn.etnshop.service;

import java.util.List;

import cz.etn.etnshop.dao.Product;

public interface ProductService {

	void addProduct(Product var1);

	void updateProduct(Product var1);

	void removeProduct(int var1);

	Product getProductById(int var1);

	List<Product> listProducts();

}
