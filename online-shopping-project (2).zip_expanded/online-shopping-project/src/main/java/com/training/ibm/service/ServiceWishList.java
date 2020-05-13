package com.training.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ibm.bean.WishList;
import com.training.ibm.repository.WishListRepository;

@Service
public class ServiceWishList {
	
	@Autowired
	WishListRepository repo;
	
	public void addToWishList(WishList wish){
		 repo.save(wish);
	}
	
	public Iterable<WishList> getAllproducts(Integer userId) {
		return repo.findByUserId(userId);
	}
	
	public void deleteFromWishList(Integer productId) {
		repo.deleteById(productId);
	}
	
	public List<Integer> getAllIds() {
		return repo.getAllId();
	}
	
	public Integer getCount(Integer userId) {
		return repo.getCount(userId);
	}
}
