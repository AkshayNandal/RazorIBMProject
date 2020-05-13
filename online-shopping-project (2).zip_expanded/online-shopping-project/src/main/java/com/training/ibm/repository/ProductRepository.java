package com.training.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.ibm.bean.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByProductName(String productName);

	List<Product> findByProductCategory(String productCategory);
	
	List<Product> findByProductSubCategory(String productSubCategory);
	
	@Query(value="select * from product where product_name like %:productName% or product_category like %:productName% or product_sub_category like %:productName%", nativeQuery = true)
	List<Product> getProductsByName(@Param("productName") String productName);
}
