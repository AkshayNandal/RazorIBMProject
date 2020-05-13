package com.training.ibm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.ibm.bean.Product;
import com.training.ibm.repository.ProductRepository;

@Service
public class ServiceProduct {

	@Autowired
	ProductRepository repo;
	
	public Iterable<Product> getProductByName(String productName){
		return repo.getProductsByName(productName);
	}

	public Iterable<Product> getAllProducts() {
		return repo.findAll();
	}

	public Optional<Product> getProductById(Integer productId) {
		return repo.findById(productId);
	}
	
	public Iterable<Product> getProductByCategory(String productCategory){
		return repo.findByProductCategory(productCategory);
	}
	
	public Iterable<Product> getProductBySubCategory(String productSubCategory){
		return repo.findByProductSubCategory(productSubCategory);
	}
	
	public void addProduct(Product product) {
		repo.save(product);
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public void updateProduct(Product product) {
		repo.save(product);
	}
}
