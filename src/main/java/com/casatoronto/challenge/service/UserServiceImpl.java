package com.casatoronto.challenge.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casatoronto.challenge.exception.AppException;
import com.casatoronto.challenge.exception.EmailInUseException;
import com.casatoronto.challenge.exception.UsernameInUseException;
import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;
import com.casatoronto.challenge.model.User;
import com.casatoronto.challenge.payload.UserRequest;
import com.casatoronto.challenge.repository.CasaTorontoRepository;
import com.casatoronto.challenge.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getInstanceOfEntityModel() {
		return new User();
	}

	@Override
	public CasaTorontoRepository<User, String> getRepository() {
		return repository;
	}

	@Override
	public Optional<User> insert(UserRequest userRequest) {
		User user = this.create(userRequest);

		if (repository.existsByUsername(user.getUsername())) {
			throw new UsernameInUseException();
		}

		if (repository.existsByEmail(user.getEmail())) {
			throw new EmailInUseException();
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleService.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		return Optional.of(repository.insert(user));
	}

	@Override
	public Optional<User> findByUsernameOrEmail(String username, String email) {
		return repository.findByUsernameOrEmail(username, email);
	}
}
