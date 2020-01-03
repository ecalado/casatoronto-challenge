package com.casatoronto.challenge.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

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
public class Travel {

	private final UUID id;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate checkIn;

	@NonNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private final LocalDate checkOut;

	private int extraNightsAfter;

	private int weeks;

	private int extraNightsBefore;

	public Travel(@JsonProperty("id") UUID id, @JsonProperty("checkIn") LocalDate checkIn,
			@JsonProperty("checkOut") LocalDate checkOut) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.countNightsAndWeeks();
	}

	public UUID getId() {
		return this.id;
	}

	public LocalDate getCheckIn() {
		return this.checkIn;
	}

	public LocalDate getCheckOut() {
		return this.checkOut;
	}

	public int getExtraNightsBefore() {
		return this.extraNightsBefore;
	}

	public int getExtraNightsAfter() {
		return this.extraNightsAfter;
	}

	public int getWeeks() {
		return this.weeks;
	}

	/*
	 * This method is used for calculating the attributes: extraNightsAfter,
	 * extraNightsAfter and weeks
	 */
	private void countNightsAndWeeks() {
		int dayOfWeekCheckIn = this.checkIn.getDayOfWeek().getValue();
		int dayOfWeekCheckOut = this.checkOut.getDayOfWeek().getValue();
		LocalDate newCheckIn = this.checkIn;
		LocalDate newCheckOut = this.checkOut;

		switch (dayOfWeekCheckIn) {
		// Sunday
		case 1:
		case 2:
			newCheckIn = newCheckIn.minusDays(dayOfWeekCheckIn);
		case 7:
			if (dayOfWeekCheckOut < 7) {
				newCheckOut = newCheckOut.minusDays(dayOfWeekCheckOut);
				this.extraNightsAfter = dayOfWeekCheckOut;
			}

			break;

		// Saturday
		case 3:
		case 4:
		case 5:
			this.extraNightsBefore = 6 - dayOfWeekCheckIn;
			newCheckIn = newCheckIn.plusDays(this.extraNightsBefore);
		case 6:
			if (dayOfWeekCheckOut < 6) {
				newCheckOut = newCheckOut.minusDays(dayOfWeekCheckOut + 1);
				this.extraNightsAfter = dayOfWeekCheckOut + 1;
			} else if (dayOfWeekCheckOut > 6) {
				newCheckOut = newCheckOut.minusDays(1);
				this.extraNightsAfter = 1;
			}

			break;
		default:
			break;
		}

		this.weeks = (int) ChronoUnit.WEEKS.between(newCheckIn, newCheckOut);

		if (this.extraNightsAfter >= 4) {
			this.extraNightsAfter = 0;
			this.weeks++;
		}
	}
}
