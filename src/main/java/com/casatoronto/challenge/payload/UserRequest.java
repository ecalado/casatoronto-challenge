package com.casatoronto.challenge.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class UserRequest extends CasaTorontoRequest {
	
	private static final long serialVersionUID = 3069376376903759323L;

	@NonNull
	@Size(min = 4, max = 40)
	private String name;

	@NonNull
	@Size(min = 3, max = 15)
	private String username;

	@NonNull
	@Size(max = 40)
	@Email
	private String email;

	@NonNull
	@Size(min = 6, max = 20)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}