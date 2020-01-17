package com.casatoronto.challenge.model.audit;

import java.util.Objects;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** @MappedSuperclass */
@JsonIgnoreProperties(value = { "createdBy", "updatedBy" }, allowGetters = true)
public abstract class UserDateAudit extends DateAudit {

	private static final long serialVersionUID = 4732387573646025871L;

	@NonNull
	@CreatedBy
	private String createdBy;

	@NonNull
	@LastModifiedBy
	private String updatedBy;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

		UserDateAudit userDateAudit = (UserDateAudit) obj;

		// field comparison
		return Objects.equals(createdBy, userDateAudit.createdBy) && Objects.equals(updatedBy, userDateAudit.updatedBy)
				&& super.equals(obj);
	}
}