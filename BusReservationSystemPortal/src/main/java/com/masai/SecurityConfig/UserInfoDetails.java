package com.masai.SecurityConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.masai.Entity.Admin;

public class UserInfoDetails implements UserDetails{

	private String name;
	private String password;
	private GrantedAuthority authority;
	
	
	
	public UserInfoDetails(User user) {
		name = user.getUsername();
		this.password = user.getPassword();
		this.authority = new SimpleGrantedAuthority("NORMUSER");
	}
	
	public UserInfoDetails(Admin admin) {
		name = admin.getUserName();
		this.password = admin.getPassword();
		this.authority = new SimpleGrantedAuthority("ADMIN");
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(authority);
		return list;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
