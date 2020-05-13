package com.ibm.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*",allowedHeaders="*")

public class UserController {
	
	@Autowired
	private MailService mailService;
	@Autowired
	UserService service;
	
	@Autowired
	UserRepository repo;
	static int otp1=generateOTP();
	@RequestMapping(method = RequestMethod.POST, value = "/register/users")
	String register(@RequestBody User user) throws Exception {
		if((repo.findByEmailAndPassword(user.getEmail(),user.getPassword())).isPresent()) {
			System.out.println("Email already exists");
			return "Email already exists";
		}else {
			mailService.send("tejsrireddy29@gmail.com","Online Shopping!!!","Your otp is "+otp1);
				service.register(user);
				System.out.println("User added");
			return "Success";
		}
	}
	
	public static int generateOTP() {
		int otp=(int)(Math.random()*1000000);
		return otp;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	void updateUser(@RequestBody User user) {
		service.updateUser(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		
	}
	@RequestMapping("/login/{email}/{password}")
	public String login(@PathVariable String email,@PathVariable String password)
	{
		User user=repo.findByEmail(email);
		if(user!=null) {
		if(!user.getPassword().equals(password)) {
			System.out.println("Invalid Password");
			return "passwordFailed";
		}else{
			System.out.println("Successfully logged in!");
			return "success";
		}}else {
			return "userFail";
		}
	}

	
	@RequestMapping("/validateOtp/{otp}")
	public String validateOtp(@PathVariable int otp) {

		if (otp == otp1) {
			System.out.println("Valid OTP");
			return "valid";
		} else {
         return "invalid";
		}
	}
	
	@RequestMapping("/users/details/{email}")
	public User findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/users")
	public Iterable<User> findAll() {
		return service.findAll();
	}
}
