package com.casatoronto.challenge.service;

import java.util.Optional;

import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;

public interface RoleService {

	public Optional<Role> findByName(RoleName roleName);
	
	public Optional<Role> insert(Role role);
}
