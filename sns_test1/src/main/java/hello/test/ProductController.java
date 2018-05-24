package hello.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.test.entity.Product;
import hello.test.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//@RequestMapping,post 等价于 @PostMapping
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseBody
	Product add(@RequestParam(value="productName")String productName,
			@RequestParam(value="productType")Integer productType,
			@RequestParam(value="createUser")String createUser){
		
		Product prod = new Product(productName,productType,createUser);
		
		return productService.addProduct(prod);
	}
	
	
	@GetMapping(value="/info/{productId}")
	public Product getInfoById(@PathVariable Integer productId){
		return productService.getInfoById(productId);
	}
	
	@GetMapping(value="/info/select")
	public List<Product> getProducts(@RequestParam(value="productId",required=false) String productId,
			@RequestParam(value="productName",required=false) String productName,
			@RequestParam(value="productType",required=false) String productType,
			@RequestParam(value="createUser",required=false) String createUser){
		
		Product prod  = new Product(Integer.parseInt(productId),productName,Integer.parseInt(productType),createUser);
		return productService.getInfos(prod);
	}
	
	
	@PostMapping("/info/selectInfo")
	public List<Product> getProductInfos(@RequestBody Product prod){
		
		return productService.getInfos(prod);
		
	}
	

}
