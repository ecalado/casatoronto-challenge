package com.casatoronto.challenge.model.audit;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** @MappedSuperclass */
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public abstract class DateAudit implements Serializable {

	private static final long serialVersionUID = 2019996198389433296L;

	@NonNull
	@CreatedDate
	private Instant createdAt;

	@NonNull
	@LastModifiedDate
	private Instant updatedAt;

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public boolean equals(Object obj) {
		// self check
		if (this == obj)
			return true;
		// null check
		if (obj == null)
			return false;
		// type check and cast
		if (getClass() != obj.getClass())
			return false;

		DateAudit dateAudit = (DateAudit) obj;

		// field comparison
		return Objects.equals(createdAt, dateAudit.createdAt) && Objects.equals(updatedAt, dateAudit.updatedAt);
	}
}