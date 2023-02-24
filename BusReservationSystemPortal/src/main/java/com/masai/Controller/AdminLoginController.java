package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Entity.Admin;
import com.masai.Entity.User;
import com.masai.Exception.UserException;
import com.masai.Service.AdminServiceImpl;
import com.masai.Service.UserServiceImpl;

@RestController
@RequestMapping("/login")
public class AdminLoginController {
	
	@Autowired
	UserServiceImpl userSer;
	
	@Autowired
	AdminServiceImpl adminSer;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) throws UserException {
		
		Admin adm =  adminSer.getAdminByemail(admin);
		
		ResponseEntity<Admin> res = new ResponseEntity<>(adm, HttpStatus.ACCEPTED);		
	
		return res;
	}
	
	@GetMapping("/user")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws UserException {
		User usr =  userSer.getUserByemail(user);
		
		ResponseEntity<User> res = new ResponseEntity<>(usr, HttpStatus.ACCEPTED);		
	
		return res;
	}
}
