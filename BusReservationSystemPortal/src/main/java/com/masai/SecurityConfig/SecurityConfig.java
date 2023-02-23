package com.masai.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new UserInfoDetailSevice();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/signIn/user").permitAll()
			.and()
			.authorizeHttpRequests()
			.requestMatchers("/login/**").permitAll()
			.anyRequest().authenticated().and()
			.addFilterAfter(new JwtTokenGenratorFilter(), BasicAuthenticationFilter.class)
			.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
			.formLogin()
			.and()
			.httpBasic();
			
		return http.build();
		
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