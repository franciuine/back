package br.com.digitalRepository.back.controller;

import java.util.List;
import java.util.Optional;

import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.entity.enums.RoleType;
import br.com.digitalRepository.back.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins = "*")
public class UserController {
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId).get();
	}

	@GetMapping("/get/user/{username}")
	public User findByUsername(@PathVariable(value = "username") String username) {
		return userRepository.findByUsername(username);
	}

	@PostMapping("/save") 
	public User save(@RequestBody User user) throws Exception {
		try {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			user.setRole(RoleType.ROLE_USER);
			return userRepository.save(user);
		} catch (DataIntegrityViolationException ex) {
            throw new Exception("Já existe um usuário com este login.");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findById(userId).get();
		userRepository.delete(user);
	}

	@GetMapping(value="/logout")
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	
	private String restorePassword(Long id) throws Exception {
        Optional<User> current = userRepository.findById(id);
        if (current.isPresent()) {
            return current.get().getPassword();
        }
        throw new Exception("Usuário não encontrado");
    }

	@GetMapping(value="/currentuser")
	public @ResponseBody String GetCurrentUser()
	{		
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}

	@GetMapping(value="/add")
	public @ResponseBody String AdicionarUsuarios()
	{
    	User user = new User();
    	user.setRole(RoleType.ROLE_ADMIN);
		user.setName("Franciuíne Almeida");
    	user.setUsername("fran");
    	user.setPassword(bCryptPasswordEncoder.encode("teste2009"));
    	userRepository.save(user);

		return "ok";
	}    	
    
    
    @GetMapping(value="/usuario")
	public @ResponseBody String Usuario()
	{
		return "ok";
	}
    
    @GetMapping(value="/admin")
	public @ResponseBody String Admin()
	{
		return "ok";
	}
    
    
    @GetMapping(value="/qualquer")
	public @ResponseBody String QualquerPermissao()
	{
		return "ok";
	}


}
