package com.casatoronto.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.service.TravelService;

@RequestMapping("api/v1/travel")
@RestController
public class TravelController {

	private final TravelService service;

	@Autowired
	public TravelController(@Qualifier("default") TravelService service) {
		this.service = service;
	}

	@GetMapping
	public List<Travel> getAll() {
		return service.list();
	}

	@PostMapping
	public Travel add(@Validated @NonNull @RequestBody Travel travel) {
		return service.add(travel);
	}	
}
