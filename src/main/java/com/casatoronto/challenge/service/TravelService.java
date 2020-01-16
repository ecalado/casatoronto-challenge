package com.casatoronto.challenge.service;

import java.util.List;

import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.payload.TravelPeriodRequest;
import com.casatoronto.challenge.payload.TravelRequest;

public interface TravelService extends CasaTorontoService<Travel, TravelRequest, String> {

	public List<Travel> findAllByCheckInBetween(TravelPeriodRequest travelPeriodRequest);

}
