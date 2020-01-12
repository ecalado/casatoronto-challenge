package com.casatoronto.challenge.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;

@Repository
public interface RoleRepository extends CasaTorontoRepository<Role, String> {
	
	public Optional<Role> findByName(RoleName roleName);
}