package com.casatoronto.challenge.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.casatoronto.challenge.model.Travel;

@Repository("arrayDao")
public class TravelDaoArray implements TravelDao {

	private static List<Travel> DB = new ArrayList<Travel>();

	@Override
	public Travel insert(UUID id, Travel travel) {
		Travel newTravel = new Travel(id, travel.getCheckIn(), travel.getCheckOut());

		DB.add(newTravel);

		return newTravel;
	}

	@Override
	public List<Travel> list() {
		return DB;
	}
}
