package com.casatoronto.challenge.model;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.casatoronto.challenge.model.audit.UserDateAudit;

public abstract class CasaTorontoModel extends UserDateAudit {

	private static final long serialVersionUID = -1139379903208466343L;

	@MongoId(FieldType.OBJECT_ID)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
