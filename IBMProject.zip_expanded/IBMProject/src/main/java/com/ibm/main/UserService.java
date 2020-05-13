package com.ibm.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public void register(User user) throws Exception
	{
		repo.save(user);
	}
	
	void updateUser(User user) {
		repo.save(user);
	}
	
	void deleteUser(int userId) {
		repo.deleteById(userId);
	}
	
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Iterable<User> findAll() {
		return repo.findAll();
	}

	
}
