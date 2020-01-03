package com.casatoronto.challenge.dao;

import java.util.List;
import java.util.UUID;

import com.casatoronto.challenge.model.Travel;

public interface TravelDao {

	public Travel insert(UUID id, Travel travel);

	default Travel add(Travel travel) {
		UUID id = UUID.randomUUID();
		return insert(id, travel);
	}

	public List<Travel> list();
}
