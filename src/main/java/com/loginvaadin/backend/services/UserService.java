package com.loginvaadin.backend.services;

import com.loginvaadin.backend.entities.User;
import com.loginvaadin.backend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void registerNewUser(String username, String password) {
//		if (!isUserRegistered(username))
		logger.info("Registering a new user!");
		userRepository.save(new User(username, passwordEncoder.encode(password)));
	}

	public boolean isRegistered(String username) {
		return userRepository.existsUsersByUsername(username);
	}
}
