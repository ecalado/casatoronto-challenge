package com.casatoronto.challenge.service;

import java.util.Optional;

import com.casatoronto.challenge.model.User;
import com.casatoronto.challenge.payload.SignUpRequest;

public interface UserService {

	public Optional<User> findById(String id);

	public Optional<User> findByUsernameOrEmail(String username, String email);

	public User create(SignUpRequest signupRequest);

	public User create(SignUpRequest signupRequest, User user);

	public Optional<User> insert(SignUpRequest signupRequest);
}
