package com.training.ibm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.ibm.bean.Product;
import com.training.ibm.service.ServiceProduct;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	ServiceProduct service;
	
	@RequestMapping("/products/name/{productName}")
	Iterable<Product> getProductByName(@PathVariable String productName){
		return service.getProductByName(productName);
	}
	
	
	@RequestMapping("/products")
	Iterable<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@RequestMapping("/products/id/{productId}")
	Optional<Product> getProductById(@PathVariable Integer productId){
		return service.getProductById(productId);
	}
	
	@RequestMapping("/getProducts")
	public ModelAndView printAllProducts(){
		ModelAndView view = new ModelAndView("index.html");
		view.addObject("products", "hello");
		return view;
	}
	
	@RequestMapping("/products/category/{productCategory}")
	Iterable<Product> getProductByCategory(@PathVariable String productCategory){
		return service.getProductByCategory(productCategory);
	}
	
	@RequestMapping("/products/subCategory/{productSubCategory}")
	Iterable<Product> getProductBySubCategory(@PathVariable String productSubCategory){
		return service.getProductBySubCategory(productSubCategory);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/products")
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
	void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/update")
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
}
