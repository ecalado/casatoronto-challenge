package com.casatoronto.challenge.payload;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TravelRequest
 * 
 * class responsible for request checkIn and checkOut information.
 * 
 * @author ecalado@gmail.com
 *
 */
public class TravelRequest extends CasaTorontoRequest {

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
}
