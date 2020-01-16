package com.casatoronto.challenge.model;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.casatoronto.challenge.model.audit.UserDateAudit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";

		try {
			jsonInString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonInString;
	}
}
