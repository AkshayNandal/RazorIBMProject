package com.ibm.main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	Iterable<Product> getAllProducts(){
		return repo.findAll();
	}
	
	Optional<Product> getProductById(int id){
		return repo.findById(id);
	}
	
	void addProduct(Product product) {
		repo.save(product);
	}
	
	void deleteProduct(int id) {
		repo.deleteById(id);
	}
	void updateProduct(Product product){
		repo.save(product);
	}
}
