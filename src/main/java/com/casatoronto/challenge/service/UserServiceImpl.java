package com.casatoronto.challenge.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casatoronto.challenge.exception.AppException;
import com.casatoronto.challenge.exception.EmailInUseException;
import com.casatoronto.challenge.exception.UsernameInUseException;
import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;
import com.casatoronto.challenge.model.User;
import com.casatoronto.challenge.payload.SignUpRequest;
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
	public User create(SignUpRequest signupRequest) {
		User user = new User();

		this.create(signupRequest, user);

		return user;
	}

	@Override
	public User create(SignUpRequest signupRequest, User user) {
		BeanUtils.copyProperties(signupRequest, user);

		return user;
	}

	@Override
	public Optional<User> insert(SignUpRequest signupRequest) {
		User user = this.create(signupRequest);

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
	public Optional<User> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<User> findByUsernameOrEmail(String username, String email) {
		return repository.findByUsernameOrEmail(username, email);
	}

}
