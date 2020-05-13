package com.training.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.ibm.bean.Orders;
import com.training.ibm.service.ServiceOrder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

	@Autowired
	ServiceOrder service;
	
	@RequestMapping(method=RequestMethod.POST, value="/orders/{userId}")
	void addToOrder(@RequestBody Orders order, @PathVariable Integer userId) {
		order.setSubTotal(order.getProductPrice() * order.getProductQuantity());
		order.setUserId(userId);
		service.addToOrder(order);
	}
	
	@RequestMapping("/orders/{userId}") 
	Iterable<Orders> getOrders(@PathVariable Integer userId){
		return service.getOrders(userId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/orders/cancel/{orderId}")
	void cancelOrder(@PathVariable Integer orderId) {
		service.cancelOrder(orderId);
	}
}
