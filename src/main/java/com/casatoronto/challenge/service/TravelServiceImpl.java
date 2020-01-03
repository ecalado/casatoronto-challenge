package com.casatoronto.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.casatoronto.challenge.dao.TravelDao;
import com.casatoronto.challenge.model.Travel;

@Service("default")
public class TravelServiceImpl implements TravelService {

	private final TravelDao dao;
	
	@Autowired
	public TravelServiceImpl(@Qualifier("mongoDBDao") TravelDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Travel add(Travel travel) {
		
		if (travel.getCheckOut().isEqual(travel.getCheckIn())
				|| travel.getCheckOut().isBefore(travel.getCheckIn())) {
			throw new CheckOutIsLTECheckInException();			
		}
		
		return dao.add(travel);
	}

	@Override
	public List<Travel> list() {
		return dao.list();
	}
}
