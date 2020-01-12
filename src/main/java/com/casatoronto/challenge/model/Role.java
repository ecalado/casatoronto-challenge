package com.casatoronto.challenge.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document("role")
public class Role extends CasaTorontoModel {

	private static final long serialVersionUID = 643929783116313565L;

	@NonNull
	private RoleName name;

	public Role() {

	}

	public Role(RoleName name) {
		this.name = name;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}
}