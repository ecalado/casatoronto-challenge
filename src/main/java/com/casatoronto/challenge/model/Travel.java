package com.casatoronto.challenge.model;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Travel
 * 
 * class responsible for saving checkIn and checkOut information.
 * 
 * @author ecalado@gmail.com
 *
 */
@Document("travel")
public class Travel extends CasaTorontoModel {

	private static final long serialVersionUID = 6068956248338948570L;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkIn;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOut;

	private int extraNightsAfter;

	private int weeks;

	private int extraNightsBefore;

	public Travel() {

	}

	public Travel(@JsonProperty("checkIn") LocalDate checkIn, @JsonProperty("checkOut") LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getExtraNightsAfter() {
		return extraNightsAfter;
	}

	public void setExtraNightsAfter(int extraNightsAfter) {
		this.extraNightsAfter = extraNightsAfter;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	public int getExtraNightsBefore() {
		return extraNightsBefore;
	}

	public void setExtraNightsBefore(int extraNightsBefore) {
		this.extraNightsBefore = extraNightsBefore;
	}
}
