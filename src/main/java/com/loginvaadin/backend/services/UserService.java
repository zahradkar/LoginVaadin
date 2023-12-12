package com.loginvaadin.backend.services;

import com.loginvaadin.backend.entities.User;
import com.loginvaadin.backend.repositories.UserRepository;
import com.loginvaadin.backend.security.SecurityUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User getUserById(String username) {
		// TODO validate id
		var user = userRepository.getReferenceById(username);
		logger.debug(user.getUsername());
		return user;
	}

	public User registerNewUser(String username, String password) {
//		if (!isUserRegistered(username))
		return userRepository.save(new User(username, passwordEncoder.encode(password)));
	}

	public boolean isRegistered(String username) {
		return userRepository.existsUsersByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userRepository.findByUsername(username);
		return user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
	}
}
