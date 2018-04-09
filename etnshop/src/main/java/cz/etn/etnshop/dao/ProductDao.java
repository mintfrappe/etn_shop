package cz.etn.etnshop.dao;

import java.util.List;

public interface ProductDao {

	void addProduct(Product var1);

	void updateProduct(Product var1);

	void removeProduct(int var1);

	Product getProductById(int var1);

	List<Product> listProducts();

}
