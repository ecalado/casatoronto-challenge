package com.casatoronto.challenge.payload;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Travel
 * 
 * class responsible for saving checkIn and checkOut information.
 * 
 * @author ecalado@gmail.com
 *
 */
public class TravelRequest implements Serializable {

	private static final long serialVersionUID = -5826595171668032872L;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate checkIn;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate checkOut;

	public TravelRequest(@JsonProperty("checkIn") LocalDate checkIn, @JsonProperty("checkOut") LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
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
