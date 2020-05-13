package com.training.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.ibm.bean.WishList;

@Repository
public interface WishListRepository extends CrudRepository<WishList, Integer>{

	@Query(value="SELECT product_id from wish_list", nativeQuery = true)
	List<Integer> getAllId();
	
	@Query(value="SELECT count(*) from wish_list group by user_id having user_id=:userId", nativeQuery = true)
	Integer getCount(@Param("userId") Integer userId);

	Iterable<WishList> findByUserId(Integer userId);
}
