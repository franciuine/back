package br.com.digitalRepository.back.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.service.UserService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtValidateFilter extends BasicAuthenticationFilter {

	private UserService userService;
	
	public JwtValidateFilter(AuthenticationManager authenticationManager, UserService userService) {
		super(authenticationManager);
		this.userService = userService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	throws IOException, ServletException
	{
		String atribute = request.getHeader("Authorization");
		
		if(atribute == null || !atribute.startsWith("Bearer "))
		{
			chain.doFilter(request, response);
			return;
		}
		String token = atribute.replace("Bearer ", "");
		UsernamePasswordAuthenticationToken  auth = getAuthenticationToken(token);
		
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
		
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(String token)
	{
		DecodedJWT jwt = JWT.require(Algorithm.HMAC512(JWTAuthFilter.TOKEN_PASSWORD))
						.build()
						.verify(token);
		
		String userName = jwt.getSubject();

		User user = userService.findByUserName(userName);
		
		Collection<GrantedAuthority> auth = new ArrayList<>();
		
		auth.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		if(user.getIsAdmin())
		{
			auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				
		}				
		
		return userName != null? new UsernamePasswordAuthenticationToken(userName, null, auth) : null;
	}

}
	