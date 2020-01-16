package com.casatoronto.challenge.payload;

import org.springframework.lang.NonNull;

import com.casatoronto.challenge.model.RoleName;

public class RoleRequest extends CasaTorontoRequest {

	private static final long serialVersionUID = 7704588365254946280L;

	@NonNull
	private RoleName name;

	public RoleRequest() {

	}

	public RoleRequest(RoleName name) {
		this.name = name;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}
}
