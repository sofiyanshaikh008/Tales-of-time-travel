package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Entity.Admin;
import com.masai.Entity.User;
import com.masai.Service.AdminServiceImpl;
import com.masai.Service.UserServiceImpl;

@RestController
@RequestMapping("/signIn")
public class SignupController {
	
	@Autowired
	UserServiceImpl userSer;
	
	@Autowired
	AdminServiceImpl adminSer;
	
	@PostMapping("/admin")
	public Admin signupAdmin(@RequestBody Admin admin) {
		
		return adminSer.registerAdmin(admin);
	}
	
	@PostMapping("/user")
	public User signupUser(@RequestBody User user) {
		
		return userSer.registerUser(user);
	}
}
