package br.com.digitalRepository.back.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.digitalRepository.back.dtos.UserDTO;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter 
{
	
	private final AuthenticationManager authenticationManager;
	public static final int TOKEN_EXPIRATION_TIME = 6000_900;
	public static final String TOKEN_PASSWORD = "werfc312-1234dgg-214g-lko90";


	public JWTAuthFilter(AuthenticationManager authenticationManager)
	{
		this.authenticationManager = authenticationManager;
		
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try
		
		{
			UserDTO userDTO = new ObjectMapper().readValue(request.getInputStream(), UserDTO.class);
					
			
						
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					
					userDTO.getUsername(),
					userDTO.getPassword(),
					new ArrayList<>()
					));
		}
		catch(Exception e)
		{
			throw new RuntimeException("Falha ao autenticar usuário" + e.getMessage(), e);
		}
		
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		UserDetail userDetail = (UserDetail)authResult.getPrincipal();
		
		String token = JWT.create()
						.withSubject(userDetail.getUsername())						
						.withExpiresAt( new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME) )
						.sign(Algorithm.HMAC512(TOKEN_PASSWORD));
		response.getWriter().write(token);		
		response.getWriter().flush();
		
	}

	
	 

}
