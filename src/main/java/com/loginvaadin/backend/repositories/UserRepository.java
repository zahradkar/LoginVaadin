package com.loginvaadin.backend.repositories;

import com.loginvaadin.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
	boolean existsUsersByUsername(String username);

	Optional<User> findByUsername(String username);
}
