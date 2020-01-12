package com.casatoronto.challenge.model.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserAuditing implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		String uname = "";
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			uname = SecurityContextHolder.getContext().getAuthentication().getName();
		} else {
			uname = "unknown user";
		}

		return Optional.of(uname);
	}
}