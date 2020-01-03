package com.casatoronto.challenge.service;

import java.util.List;

import com.casatoronto.challenge.model.Travel;

public interface TravelService {

	public Travel add(Travel travel);

	public List<Travel> list();
}
