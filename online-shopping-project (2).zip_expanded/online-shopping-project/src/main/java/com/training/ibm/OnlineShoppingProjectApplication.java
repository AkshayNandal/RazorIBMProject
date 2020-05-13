package com.training.ibm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.ibm.controller.CartController;

@SpringBootApplication
public class OnlineShoppingProjectApplication {

	@Autowired
	CartController controller;
	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingProjectApplication.class, args);
	}

}
