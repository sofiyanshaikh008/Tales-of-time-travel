package com.masai.SecurityConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.masai.Entity.Admin;
import com.masai.Repositiory.AdminRepo;
import com.masai.Repositiory.UserRepo;


public class UserInfoDetailSevice implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.masai.Entity.User> opt = userRepo.findByEmail(username);
		Optional<Admin> opt1 = adminRepo.findByEmail(username);
 		
		if(!opt.isPresent()) {
			com.masai.Entity.User user = opt.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			user.getRoles().forEach((el) -> {
				authorities.add(new SimpleGrantedAuthority(el.getRoleName() ) );
			});
			
			return new User(user.getEmail(),user.getPassword(), authorities);
			
		}
		
		
		else if(!opt1.isPresent()) {
			Admin admin = opt1.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			admin.getRoles().forEach((el) -> {
				authorities.add(new SimpleGrantedAuthority(el.getRoleName() ) );
			});
			
			return new User(admin.getEmail(),admin.getPassword(), authorities);
			
		}
		
		else throw new UsernameNotFoundException("User with user name "+ username + " does not exist.");
		
		
	}

}
