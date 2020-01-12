package com.casatoronto.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "E-mail already in use. Please choose another one.")
public class EmailInUseException extends RuntimeException {

	private static final long serialVersionUID = -4792346823124305195L;
}
