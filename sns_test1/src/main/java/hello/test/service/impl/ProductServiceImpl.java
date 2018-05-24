package hello.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.test.dao.ProductMapper;
import hello.test.entity.Product;
import hello.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper produtMapper;

	@Override
	public Product addProduct(Product prod) {
		
		Integer productId = produtMapper.insert(prod);
		
		prod.setProductId(productId);
		
		return prod;
	}

	@Override
	public Product getInfoById(Integer productId) {
		return produtMapper.selectByPrimaryKey(productId);
	}

	@Override
	public List<Product> getInfos(Product prod) {
		return produtMapper.selectInfos(prod);
	}


}
