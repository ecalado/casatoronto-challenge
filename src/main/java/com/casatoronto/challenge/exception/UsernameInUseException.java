package com.casatoronto.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Username already in use. Please choose another one.")
public class UsernameInUseException extends RuntimeException {

	private static final long serialVersionUID = -4792346823124305195L;
}
