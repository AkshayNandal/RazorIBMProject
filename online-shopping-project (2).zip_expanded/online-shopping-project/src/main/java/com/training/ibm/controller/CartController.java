package com.training.ibm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.ibm.bean.Cart;
import com.training.ibm.bean.Product;
import com.training.ibm.repository.ProductRepository;
import com.training.ibm.service.ServiceCart;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	ServiceCart service;

	@RequestMapping(method = RequestMethod.POST, value = "/cart/add/{productId}/{userId}")
	void addToCart(@RequestBody Cart cart, @PathVariable Integer productId, @PathVariable Integer userId) {
		if (!service.getAllProductsInCart(userId).iterator().hasNext()) {
			cart.setSubTotal(cart.getProductPrice() * cart.getProductQuantity());
			cart.setUserId(userId);
			service.addtoCart(cart);
		} else{
			List<Integer> temp = service.getAllIds(userId);
			for (Integer id : temp) {
				if (productId!=id) {
					continue;
				}
				cart.setProductQuantity(service.getProductQuantity(cart) + 1);
				break;
			}
			cart.setSubTotal(cart.getProductPrice() * cart.getProductQuantity());
			cart.setUserId(userId);
			service.addtoCart(cart);
		}

	}

	@RequestMapping("/cart/{userId}")
	Iterable<Cart> getAllProductsInCart(@PathVariable Integer userId) {
		return service.getAllProductsInCart(userId);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value = "/cart/{cartId}")
	void deleteFromCart(@PathVariable Integer cartId) {
		service.deleteFromCart(cartId);
	}

	@RequestMapping("/cart/total/{userId}")
	Double getTotalOfCart(@PathVariable Integer userId) {
		return service.getTotalOfCart(userId);
	}
	
	@RequestMapping("/cart/count/{userId}")
	Integer getCount(@PathVariable Integer userId) {
		return service.getCount(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cart/increment")
	void increment(@RequestBody Cart cart) {
		cart.setProductQuantity(service.getProductQuantity(cart) + 1);
		cart.setSubTotal(cart.getProductPrice() * cart.getProductQuantity());
		service.increment(cart);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cart/decrement")
	void decrement(@RequestBody Cart cart) {
		cart.setProductQuantity(service.getProductQuantity(cart) - 1);
		cart.setSubTotal(cart.getProductPrice() * cart.getProductQuantity());
		service.decrement(cart);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/cart/removeAll/{cartId}")
	void removeAll(@PathVariable Integer cartId) {
		service.removeAll(cartId);
	}
	
}
