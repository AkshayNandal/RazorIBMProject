package com.ibm.main;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email,String password);
}
