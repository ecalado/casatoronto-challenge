package com.casatoronto.challenge.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.casatoronto.challenge.model.Travel;

@Repository
public interface TravelRepository extends CasaTorontoRepository<Travel, String> {

	@Query("{ 'checkIn' : { $gte: ?0, $lte: ?1 } }")
	public List<Travel> findAllByCheckInBetween(LocalDate startDate, LocalDate endDate);
}
