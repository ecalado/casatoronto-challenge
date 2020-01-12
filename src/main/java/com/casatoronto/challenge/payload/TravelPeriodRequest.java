package com.casatoronto.challenge.payload;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TravelPeriodRequest {

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate startDate;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate endDate;

	public TravelPeriodRequest(@JsonProperty("startDate") LocalDate startDate,
			@JsonProperty("endDate") LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
}
