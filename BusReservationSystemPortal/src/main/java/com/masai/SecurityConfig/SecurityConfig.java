package com.masai.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		/*
		 * by this implementation only two users will be there
		 * 1. Harit (i.e Admin)
		 * 2. Dhiraj (i.e Normal User)
		 * We are hard coding our users in this way
		 * 
		 * 
		UserDetails admin = User.withUsername("Harit")
								.password(encoder.encode("harit123"))
								.roles("ADMIN")
								.build();
		
		UserDetails user = User.withUsername("Dhiraj")
								.password(encoder.encode("dhiraj123"))
								.roles("USER")
								.build();
		
		return new InMemoryUserDetailsManager(admin, user);
		*/
		
		return new UserInfoDetailSevice();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 return http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/home").permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/admin").authenticated()
					.and().formLogin()
					.and().build();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		/*
		 * BCryptPasswordEncode
		 * this will encode the normal password so that it remain secure
		 * and will decode when will need it
		 * */
		
		return new BCryptPasswordEncoder();
	}
}
