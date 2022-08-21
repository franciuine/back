package br.com.digitalRepository.back.security;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import br.com.digitalRepository.back.service.UserService;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter implements ApplicationContextAware{

	    private final UserDetailService service;
	    private final PasswordEncoder passwordEncoder;
	    private final UserService userService;


	    public Config(UserDetailService service, PasswordEncoder passwordEncoder, UserService userService) {
	        this.service = service;
	        this.passwordEncoder = passwordEncoder;
	        this.userService = userService;
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
			
			http.cors().and()
	        .csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.POST, "/login").permitAll()
	                .antMatchers("/user/add").permitAll()
	                .antMatchers("/pdf/get/*").permitAll()
					.antMatchers("/pdf/add/*").permitAll()              
					.antMatchers("/user/admin").hasRole("ADMIN")
	                .antMatchers("/user/usuario").hasRole("USER")
					.antMatchers("/user/save").permitAll()
	                .antMatchers("/user/currentuser").hasAnyRole("USER", "ADMIN")	     
					.antMatchers("/lessonplan/*").permitAll()         
	                .antMatchers("/user/qualquer").permitAll()
					.antMatchers("/lessonplan/all/enabled").permitAll()
					.antMatchers("/lessonplan/all/by/user/*").permitAll()
					.antMatchers("/educationlevel/all").permitAll()
					.antMatchers("/educationlevel/get/*").permitAll()
					.antMatchers("/user/login").permitAll()
					.antMatchers("/lessonplan/delete/*").permitAll()
					.anyRequest().authenticated()
	                .and()
	                .addFilter(new JWTAuthFilter(authenticationManager()))
	                .addFilter(new JwtValidateFilter(authenticationManager(), userService))
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    }


	}










