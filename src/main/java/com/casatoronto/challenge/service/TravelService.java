package com.casatoronto.challenge.service;

import java.util.List;
import java.util.Optional;

import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.payload.TravelPeriodRequest;
import com.casatoronto.challenge.payload.TravelRequest;

public interface TravelService {

	public Travel create(TravelRequest travelRequest);

	public Travel create(TravelRequest travelRequest, Travel travel);

	public List<Travel> findAll();

	public List<Travel> findAllByCheckInBetween(TravelPeriodRequest travelPeriodRequest);

	public Optional<Travel> findById(String id);

	public Optional<Travel> insert(TravelRequest travelRequest);

	public Optional<Travel> update(String id, TravelRequest travelRequest);

	public void deleteById(String id);
}
