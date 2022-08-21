package br.com.digitalRepository.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.repository.UserRepository;


@Component
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findByUserName(String userName)
	{
		return userRepository.findByUsername(userName);
	}
	
	public void save(User user)
	{
		userRepository.save(user);
	}

	
}
