package com.ibm.main;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping("/products")
	Iterable<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@RequestMapping("/products/{id}")
	Optional<Product> getProductById(@PathVariable int id){
		return service.getProductById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/products")
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/update/{id}")
	void updateProduct(@RequestBody Product product, @PathVariable int id) {
		service.updateProduct(product);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	void deleteProduct(@PathVariable int id) {
		service.deleteProduct(id);
	}
}
