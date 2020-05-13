package com.training.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.ibm.bean.WishList;
import com.training.ibm.service.ServiceWishList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WishListController {

	@Autowired
	ServiceWishList service;

	@RequestMapping(method = RequestMethod.POST, value = "/wishList/add/{userId}")
	void addToWishList(@RequestBody WishList wish, @PathVariable Integer userId) {
		wish.setUserId(userId);
		service.addToWishList(wish);
	}

	@RequestMapping("/wishList/{userId}")
	Iterable<WishList> getAllProducts(@PathVariable Integer userId) {
		return service.getAllproducts(userId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/wishList/{productId}")
	void deleteFromWishList(@PathVariable Integer productId) {
		service.deleteFromWishList(productId);
	}
	
	@RequestMapping("/wishList/count/{userId}")
	Integer getCount(@PathVariable Integer userId) {
		return service.getCount(userId);
	}
}
