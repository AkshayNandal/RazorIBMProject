package com.training.ibm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ibm.bean.Cart;
import com.training.ibm.repository.CartRepository;

@Service
public class ServiceCart {

	@Autowired
	CartRepository repo;
	
	public void addtoCart(Cart cart) {
		repo.save(cart);
	}
	
	public Iterable<Cart> getAllProductsInCart(Integer userId) {
		return repo.findByUserId(userId);
	}
	
	public void updateQuantity(Cart cart) {
		repo.save(cart);
	}
	
	public void deleteFromCart(Integer cartId) {
		repo.deleteById(cartId);
	}
	
	public Double getTotalOfCart(Integer userId) {
		return repo.getSumOfCart(userId);
	}
	
	public List<Integer> getAllIds(Integer userId) {
		return repo.getAllId(userId);
	}
	
	public Integer getProductQuantity(Cart cart) {
		return repo.getProductQuantity(cart.getCartId());
	}
	
	public Integer getCount(Integer userId) {
		return repo.getCount(userId);
	}

	public void increment(Cart cart) {
		repo.save(cart);
	}

	public void decrement(Cart cart) {
		repo.save(cart);
	}
	
	public void removeAll(Integer cartId) {
		repo.deleteById(cartId);
	}
}
