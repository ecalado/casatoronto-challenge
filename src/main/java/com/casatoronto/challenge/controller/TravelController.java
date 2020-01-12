package com.casatoronto.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.payload.TravelPeriodRequest;
import com.casatoronto.challenge.payload.TravelRequest;
import com.casatoronto.challenge.service.TravelService;

@RequestMapping("api/v1/travel")
@RestController
public class TravelController {

	@Autowired
	private TravelService service;

	@GetMapping(path = "")
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	public List<Travel> findAll() {
		return service.findAll();
	}

	@GetMapping(path = "/filterByCheckIn")
	public List<Travel> findAllByCheckInBetween(@Validated @NonNull @RequestBody TravelPeriodRequest travelPeriodRequest) {
		return service.findAllByCheckInBetween(travelPeriodRequest);
	}

	@GetMapping(path = "/get/{id}")
	public Optional<Travel> findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@PostMapping
	public Optional<Travel> insert(@Validated @NonNull @RequestBody TravelRequest travelRequest) {
		return service.insert(travelRequest);
	}

	@PutMapping(path = "{id}")
	public Optional<Travel> update(@PathVariable("id") String id,
			@Validated @NonNull @RequestBody TravelRequest travelRequest) {
		return service.update(id, travelRequest);
	}

	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") String id) {
		service.deleteById(id);
	}
}
