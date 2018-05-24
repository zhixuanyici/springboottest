package hello.test.service;

import java.util.List;

import hello.test.entity.Product;

public interface ProductService {

	public Product addProduct(Product prod);

	public Product getInfoById(Integer productId);

	public List<Product> getInfos(Product prod);
}
