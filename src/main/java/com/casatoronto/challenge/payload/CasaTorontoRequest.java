package com.casatoronto.challenge.payload;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CasaTorontoRequest implements Serializable {

	private static final long serialVersionUID = 1998837546813712484L;

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
