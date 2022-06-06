package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@RestController
@RequestMapping("/v1")
public class UserController {
	
	@GetMapping("/users")
	public List<User> findAll() {
		return null;
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable(value = "id") Long userId) {
		return null;
	}
	
	@PostMapping("/users") 
	public void save(@RequestBody User user) {
	}
	
	@DeleteMapping("/users/{id}")
	public void delet(@PathVariable(value = "id") Long userId) {
		
	}

}
