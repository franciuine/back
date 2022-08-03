package br.com.digitalRepository.back.service;

import java.beans.JavaBean;
import java.util.List;

import br.com.digitalRepository.back.entity.User;

@JavaBean
public interface UserService {
	
	User findById(long id);
	
	User save(User user);
	
	void delete(long id);
	
	List<User> findAll();
	
}
