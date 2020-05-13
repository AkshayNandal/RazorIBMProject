package com.training.ibm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.ibm.bean.Cart;
import com.training.ibm.bean.Product;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{

	@Query(value="SELECT sum(sub_total) from cart where user_id=:userId", nativeQuery = true)
	Double getSumOfCart(@Param("userId") Integer userId);
	
	@Query(value="SELECT product_id from cart WHERE user_id=:userId", nativeQuery = true)
	List<Integer> getAllId(@Param("userId") Integer userId);
	
	@Query(value="SELECT product_quantity from cart where cart_id=:id", nativeQuery = true)
	Integer getProductQuantity(@Param("id") Integer id);
	
	@Query(value="SELECT count(*) from cart where user_id=:userid", nativeQuery = true)
	Integer getCount(@Param("userid") Integer userId);

	List<Cart> findByUserId(Integer userId);

}

