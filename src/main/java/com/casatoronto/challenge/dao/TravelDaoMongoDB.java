package com.casatoronto.challenge.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.casatoronto.challenge.model.Travel;
import com.mongodb.client.MongoClients;

@Repository("mongoDBDao")
public class TravelDaoMongoDB implements TravelDao {

	private static MongoOperations mongoOps;

	public TravelDaoMongoDB() {
		mongoOps = new MongoTemplate(MongoClients.create(), "CasaToronto-Challenge");
	}

	@Override
	public Travel insert(UUID id, Travel travel) {
		Travel newTravel = new Travel(id, travel.getCheckIn(), travel.getCheckOut());

		mongoOps.insert(newTravel, "travel");

		return newTravel;
	}

	@Override
	public List<Travel> list() {
		return mongoOps.findAll(Travel.class, "travel");
	}
}
