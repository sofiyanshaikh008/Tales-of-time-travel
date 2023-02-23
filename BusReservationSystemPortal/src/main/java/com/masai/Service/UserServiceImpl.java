package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.Entity.Role;
import com.masai.Entity.User;
import com.masai.Exception.UserException;
import com.masai.Repositiory.RoleRepo;
import com.masai.Repositiory.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo role;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User registerUser(User user) {
		List<Role> list = new ArrayList<>();

		Optional<Role> r = role.findById(2);
		
		list.add(r.get());
		
		user.setRoles(list);
		
		//before saving into database encoding the password 
		user.setPassword(encoder.encode(user.getPassword()));
		
		return userRepo.save(user);

	}

	@Override
	public User getUserByemail(User user) throws UserException {
		return userRepo.findByEmail(user.getEmail()).orElseThrow(() -> new UserException("Invalid credentials"));
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}


}
