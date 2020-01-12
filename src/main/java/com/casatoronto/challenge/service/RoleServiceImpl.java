package com.casatoronto.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;
import com.casatoronto.challenge.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	public Optional<Role> findByName(RoleName roleName) {
		return repository.findByName(roleName);
	}

	@Override
	public Optional<Role> insert(Role role) {
		return Optional.of(repository.insert(role));
	}
}
