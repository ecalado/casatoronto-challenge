package com.casatoronto.challenge.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;


@Document("user")
public class User extends CasaTorontoModel {

	private static final long serialVersionUID = -660270555869657669L;

	@NonNull
	@Size(max = 40)
	private String name;

	@NonNull
	@Size(max = 15)
	private String username;

	@NonNull
	@Size(max = 40)
	@Email
	private String email;

	@NonNull
	@Size(max = 100)
	private String password;

	private Set<Role> roles = new HashSet<Role>();

	public User() {

	}

	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}