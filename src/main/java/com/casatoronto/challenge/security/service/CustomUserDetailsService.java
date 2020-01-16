package com.casatoronto.challenge.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.casatoronto.challenge.exception.ResourceNotFoundException;
import com.casatoronto.challenge.model.User;
import com.casatoronto.challenge.security.model.UserPrincipal;
import com.casatoronto.challenge.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// Let people login with either username or email
		User user = userService.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));

		return UserPrincipal.create(user);
	}

	public UserDetails loadUserById(String id) {
		User user = userService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id));

		return UserPrincipal.create(user);
	}
}