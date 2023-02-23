package com.masai.SecurityConfig;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGenratorFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		if(null != authentication) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());
			
			String jwt = Jwts.builder()
					.setIssuer("Harit")
					.setSubject("JWT Token")
					.claim("usenmae", authentication.getName())
					.claim("authorities", getAuthorities(authentication.getAuthorities()))
					.setIssuedAt(new Date(new Date().getTime()+30000000))
					.signWith(key, SignatureAlgorithm.ES256).compact();
			
			response.setHeader(SecurityConstant.JWT_HEADER, jwt);
		}
	}
	
	private String getAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authSet = new HashSet<>();
		
		for(GrantedAuthority auth : collection) {
			authSet.add(auth.getAuthority());
		}
		
		return String.join(",", authSet);
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
		return !request.getServletPath().equals("/signIn");
	}

}
