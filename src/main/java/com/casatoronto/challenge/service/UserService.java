package com.casatoronto.challenge.service;

import java.util.Optional;

import com.casatoronto.challenge.model.User;
import com.casatoronto.challenge.payload.UserRequest;

public interface UserService extends CasaTorontoService<User, UserRequest, String> {

	public Optional<User> findByUsernameOrEmail(String username, String email);
}
