package com.casatoronto.challenge.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casatoronto.challenge.exception.CheckOutIsLTECheckInException;
import com.casatoronto.challenge.exception.ResourceNotFoundException;
import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.payload.TravelPeriodRequest;
import com.casatoronto.challenge.payload.TravelRequest;
import com.casatoronto.challenge.repository.TravelRepository;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private TravelRepository repository;

	@Override
	public Travel create(TravelRequest travelRequest) {
		Travel travel = new Travel();

		this.create(travelRequest, travel);

		return travel;
	}

	@Override
	public Travel create(TravelRequest travelRequest, Travel travel) {
		BeanUtils.copyProperties(travelRequest, travel);

		return travel;
	}

	@Override
	public List<Travel> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Travel> findAllByCheckInBetween(TravelPeriodRequest travelPeriodRequest) {
		return repository.findAllByCheckInBetween(travelPeriodRequest.getStartDate(), travelPeriodRequest.getEndDate());
	}

	@Override
	public Optional<Travel> findById(String id) {
		Travel travel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Travel.class.getSimpleName(), "id", id));
		return Optional.of(travel);
	}

	@Override
	public Optional<Travel> insert(TravelRequest travelRequest) {
		Travel travel = this.create(travelRequest);

		this.checkOutIsLTECheckIn(travel);

		this.countNightsAndWeeks(travel);

		return Optional.of(repository.insert(travel));
	}

	@Override
	public Optional<Travel> update(String id, TravelRequest travelRequest) {
		Travel travel = this.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Travel.class.getSimpleName(), "id", id));

		travel = this.create(travelRequest, travel);

		this.checkOutIsLTECheckIn(travel);

		this.countNightsAndWeeks(travel);

		return Optional.of(repository.save(travel));
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	/*
	 * This method is used for validating if checkOut is less than checkIn or
	 * checkOut equal to checkIn
	 * 
	 * @throws CheckOutIsLTECheckInException
	 */
	private void checkOutIsLTECheckIn(Travel travel) {
		if (travel.getCheckOut().isEqual(travel.getCheckIn()) || travel.getCheckOut().isBefore(travel.getCheckIn())) {
			throw new CheckOutIsLTECheckInException();
		}
	}

	/*
	 * This method is used for calculating the attributes: extraNightsAfter,
	 * extraNightsAfter and weeks
	 */
	private void countNightsAndWeeks(Travel travel) {
		LocalDate newCheckIn = travel.getCheckIn();
		LocalDate newCheckOut = travel.getCheckOut();

		int dayOfWeekCheckIn = newCheckIn.getDayOfWeek().getValue();
		int dayOfWeekCheckOut = newCheckOut.getDayOfWeek().getValue();

		int numberOfDays = (int) ChronoUnit.DAYS.between(newCheckIn, newCheckOut);
		int extraNightsAfter = 0;
		int extraNightsBefore = 0;
		int weeks = 0;

		if (numberOfDays >= 4 && numberOfDays < 7) {
			extraNightsAfter = 0;
			extraNightsBefore = 0;
			weeks = 1;
		} else {
			switch (dayOfWeekCheckIn) {
			// Sunday
			case 1:
			case 2:
				newCheckIn = newCheckIn.minusDays(dayOfWeekCheckIn);
			case 7:
				if (dayOfWeekCheckOut < 7) {
					newCheckOut = newCheckOut.minusDays(dayOfWeekCheckOut);
					extraNightsAfter = dayOfWeekCheckOut;
				}

				break;

			// Saturday
			case 3:
			case 4:
			case 5:
				extraNightsBefore = 6 - dayOfWeekCheckIn;
				newCheckIn = newCheckIn.plusDays(extraNightsBefore);

			case 6:
				if (dayOfWeekCheckOut < 6) {
					newCheckOut = newCheckOut.minusDays(dayOfWeekCheckOut + 1);
					extraNightsAfter = dayOfWeekCheckOut + 1;
				} else if (dayOfWeekCheckOut > 6) {
					newCheckOut = newCheckOut.minusDays(1);
					extraNightsAfter = 1;
				}

				break;
			default:
				break;
			}

			if (newCheckOut.isAfter(newCheckIn)) {
				weeks = (int) ChronoUnit.WEEKS.between(newCheckIn, newCheckOut);

				if (extraNightsAfter >= 4) {
					extraNightsAfter = 0;
					weeks++;
				}
			} else {
				newCheckIn = travel.getCheckIn();
				newCheckOut = travel.getCheckOut();

				extraNightsBefore = (int) ChronoUnit.DAYS.between(newCheckIn, newCheckOut);

				extraNightsAfter = 0;
				weeks = 0;

				if (extraNightsBefore >= 4) {

					if (dayOfWeekCheckIn >= 3 && dayOfWeekCheckIn <= 6 && extraNightsBefore >= 7) {
						extraNightsBefore = 6 - dayOfWeekCheckIn;
					} else {
						extraNightsBefore = 0;
					}
					weeks = 1;
				}
			}
		}

		travel.setExtraNightsBefore(extraNightsBefore);
		travel.setExtraNightsAfter(extraNightsAfter);
		travel.setWeeks(weeks);
	}
}
