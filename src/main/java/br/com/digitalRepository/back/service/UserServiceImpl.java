package br.com.digitalRepository.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	Optional<User> findById(long id) {
		return userRepository.findById(id);
	}
	
	User save(User user) throws Exception {
		try {
            if (user.getId() != 0) {
                user.setPassword(restorePassword(user.getId()));
            } else {
            	user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            }
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new Exception("Nome de usuário já cadastrado.");
        }
	}
	
	void delete(long id) {
		userRepository.deleteById(id);
		
	}
	
	List<User> findAll() {
		return userRepository.findAll();
	}
	
	private String restorePassword(Long id) throws Exception {
        Optional<User> current = userRepository.findById(id);
        if (current.isPresent()) {
            return current.get().getPassword();
        }
        throw new Exception("Usuário não encontrado");
    }

}
