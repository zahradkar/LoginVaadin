package com.loginvaadin.backend.entities;

import jakarta.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}
}
