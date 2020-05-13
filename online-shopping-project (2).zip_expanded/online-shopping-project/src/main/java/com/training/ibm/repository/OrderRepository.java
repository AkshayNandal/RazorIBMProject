package com.training.ibm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.ibm.bean.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer>{

	Iterable<Orders> findByUserId(Integer userId);

}
