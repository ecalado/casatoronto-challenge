package com.casatoronto.challenge.service;

import java.util.Optional;

import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;
import com.casatoronto.challenge.payload.RoleRequest;

public interface RoleService extends CasaTorontoService<Role, RoleRequest, String> {

	public Optional<Role> findByName(RoleName roleName);
}
