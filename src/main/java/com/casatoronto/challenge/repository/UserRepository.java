package com.casatoronto.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.casatoronto.challenge.model.User;

@Repository
public interface UserRepository extends CasaTorontoRepository<User, String>{

	public Optional<User> findByEmail(String email);

	public Optional<User> findByUsernameOrEmail(String username, String email);

	public List<User> findByIdIn(List<String> userIds);

	public Optional<User> findByUsername(String username);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);
}
