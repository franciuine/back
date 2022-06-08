package br.com.digitalRepository.back.controller;

import java.util.List;

import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@RestController
@RequestMapping("/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId).get();
	}
	
	@PostMapping("/users") 
	public User save(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findById(userId).get();
		userRepository.delete(user);
	}

}
