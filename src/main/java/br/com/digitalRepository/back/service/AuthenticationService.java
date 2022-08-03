package br.com.digitalRepository.back.service;

import org.springframework.stereotype.Service;

import br.com.digitalRepository.back.entity.User;
import br.com.digitalRepository.back.repository.UserRepository;
import br.com.digitalRepository.back.security.JwtUtils;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final JwtUtils jwtUtils;

    public AuthenticationService(UserRepository repository, JwtUtils jwtUtils) {
        this.repository = repository;
        this.jwtUtils = jwtUtils;
    }

    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    public User findAuthenticatedUser(String username) {
        User user = findUserByUsername(username);
             user.setToken(jwtUtils.generateToken(user));
             user.setPassword(null);
        return user;
    }

}