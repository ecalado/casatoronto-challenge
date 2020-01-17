package com.casatoronto.challenge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.datatables.DataTablesInput;
import org.springframework.data.mongodb.datatables.DataTablesOutput;

import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.payload.TravelRequest;
import com.casatoronto.challenge.service.TravelService;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TravelServiceDataTableTests {

	@Autowired
	private TravelService service;

	@BeforeAll
	void init() {
		service.deleteAll();
	}

	@Test
	@Order(1) 
	void testNights01() {
		LocalDate checkIn = LocalDate.of(2019, Month.JUNE, 05);
		LocalDate checkOut = LocalDate.of(2019, Month.AUGUST, 27);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 11, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(2) 
	void testNights02() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 16);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 27);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(3) 
	void testNights03() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 4);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(4) 
	void testNights04() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 19);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(5) 
	void testNights05() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 20);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), (int) travel.getWeeks(),
				travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(6) 
	void testNights06() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 21);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(7) 
	void testNights07() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 22);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(8) 
	void testNights08() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 23);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 3, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(9) 
	void testNights09() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(10) 
	void testNights10() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 12);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(11) 
	void testNights11() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 13);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(12) 
	void testNights12() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 24);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 3, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	@Order(13)
	void testNights13() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 14);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	@Order(14)
	void testNights14() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(15) 
	void testNights15() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(16) 
	void testNights16() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 16);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(17) 
	void testNights17() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 17);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(18) 
	void testNights18() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(19) 
	void testNights19() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 19);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(20) 
	void testNights20() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@Order(21)
	void basic() {
		
		DataTablesInput input = TravelRequest.getDefaultInput();
		
		//Length -1 for return all registers
		int length = 5;
		input.setLength(length);
		
		DataTablesOutput<Travel> output = service.findAll(input);

		assertThat(output.getDraw()).isEqualTo(1);
		assertThat(output.getError()).isNull();
		assertThat(output.getRecordsFiltered()).isEqualTo(length>=0?length:20);
		assertThat(output.getRecordsTotal()).isEqualTo(20);
		
		//Because all registers was return
		List<Travel> travels = service.findAll();
		
		int idx = 0;
		while (idx < length && idx < travels.size()) {
			Travel travel = travels.get(idx);
			assertThat(output.getData().get(idx)).isEqualTo(travel); 
			idx++;
		}
	}

}
