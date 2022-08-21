package br.com.digitalRepository.back.security;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetail implements UserDetails{

	private static final long serialVersionUID = 1L;

	private String Username;
	private String Password;
	private boolean isAdmin;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auth = new ArrayList<>();
		
		auth.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		if(isAdmin())
		{
			auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				
		}
		 
		return auth;
	}

	@Override
	public String getPassword() {
		return Password;
	}

	@Override
	public String getUsername() {
			return Username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public void setUsername(String Username) {
		this.Username = Username;
	}


	public void setPassword(String Password) {
		this.Password = Password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
