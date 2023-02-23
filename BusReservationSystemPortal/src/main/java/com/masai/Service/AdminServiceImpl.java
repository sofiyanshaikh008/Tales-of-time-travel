package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.masai.Entity.Admin;
import com.masai.Entity.Role;
import com.masai.Exception.UserException;
import com.masai.Repositiory.AdminRepo;
import com.masai.Repositiory.RoleRepo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private RoleRepo role;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Admin registerAdmin(Admin admin) {
		
		List<Role> list = new ArrayList<>();

		Optional<Role> r = role.findById(1);
		
		list.add(r.get());
		
		admin.setRoles(list);
		
		//before saving into database encoding the password 
		admin.setPassword(encoder.encode(admin.getPassword()));
		
		adminRepo.save(admin);
		
		return admin;
	}

	@Override
	public Admin getAdminByemail(Admin admin) throws UserException {
		
		return adminRepo.findByEmail(admin.getEmail()).orElseThrow(() -> new UserException("Invalid credentials"));
	
	}
	
}
