package com.casatoronto.challenge.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "CheckOut can not be less than or equal to CheckIn.")
public class CheckOutIsLTECheckInException extends RuntimeException {

	private static final long serialVersionUID = -4792346823124305195L;
}
