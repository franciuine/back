package br.com.digitalRepository.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.repository.UserRepository;



@Component
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException("Login não existe");
		
		UserDetail userDetail = new UserDetail();
		userDetail.setAdmin(user.getIsAdmin());
		userDetail.setUsername(user.getUsername());
		userDetail.setPassword(user.getPassword());
		
		return userDetail;
	}

}
