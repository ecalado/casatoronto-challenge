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
	public Role getInstanceOfEntityModel() {
		return new Role();
	}

	@Override
	public RoleRepository getRepository() {
		return repository;
	}
	
	@Override
	public Optional<Role> findByName(RoleName roleName) {
		return repository.findByName(roleName);
	}
}
