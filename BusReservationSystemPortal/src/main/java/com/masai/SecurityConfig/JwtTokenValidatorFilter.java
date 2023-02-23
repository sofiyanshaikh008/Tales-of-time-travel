package com.masai.SecurityConfig;

import java.io.IOException;
import java.util.List;
import javax.crypto.SecretKey;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidatorFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt = request.getHeader(SecurityConstant.JWT_HEADER);
		
		if(jwt != null) {
			
			try {
				
				jwt = jwt.substring(7);
				
				SecretKey key = Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes());
				
				Claims claim = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				
				String username = String.valueOf(claim.get("username"));
				
				String authorities = (String) claim.get("authorities");
				
				List<GrantedAuthority> authList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
				
				Authentication auth = new UsernamePasswordAuthenticationToken(username, null, authList);
				
			}
			catch(Exception e) {
				throw new BadCredentialsException("Invalid Token");
			}
			
			
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
		return !request.getServletPath().equals("/signIn");
	}

}
