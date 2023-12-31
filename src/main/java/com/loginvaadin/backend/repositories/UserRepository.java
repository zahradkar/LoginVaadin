package com.loginvaadin.backend.repositories;

import com.loginvaadin.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	boolean existsUsersByUsername(String username);

	//	Optional<User> findByUsername(String username);
	User findByUsername(String username);
}
