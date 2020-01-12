package com.casatoronto.challenge;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casatoronto.challenge.model.Travel;
import com.casatoronto.challenge.payload.TravelRequest;
import com.casatoronto.challenge.service.TravelService;

@SpringBootTest
class TravelServiceTests {

	@Autowired
	private TravelService service;

	@Test
	void testNights43() {
		LocalDate checkIn = LocalDate.of(2019, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2019, Month.JANUARY, 04);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		System.out.println(travel);
		int[] expecteds = new int[] { 3, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights1() {
		LocalDate checkIn = LocalDate.of(2019, Month.JUNE, 05);
		LocalDate checkOut = LocalDate.of(2019, Month.AUGUST, 27);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 11, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights2() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 16);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 27);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights3() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 4);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights4() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 19);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights5() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 20);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), (int) travel.getWeeks(),
				travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights6() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 21);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights7() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 22);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights8() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 23);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 3, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights9() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights10() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 12);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights11() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 13);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights14() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights15() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights16() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 16);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights17() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 17);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights18() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights19() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 04);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 19);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights20() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights21() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights22() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 03);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights23() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights24() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 16);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights25() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 17);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights26() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights27() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 19);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 2, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights28() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 12);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights29() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 13);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights30() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights31() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights32() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 16);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights33() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 17);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights34() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights35() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 19);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights36() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 05);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 20);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	void testNights37() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 12);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights38() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 13);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 1 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights39() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 2 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights40() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 3 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights41() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 16);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights42() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 07);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 16);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 2, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights44() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 04);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights45() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 03);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights46() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 04);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights47() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 05);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights48() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 06);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights49() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 03);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 06);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights50() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 07);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights51() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 8);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights52() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 9);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights53() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 02);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 10);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights54() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 8);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights55() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 9);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights56() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 01);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 10);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights57() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 7);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights58() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 8);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights59() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 9);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights60() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 06);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 10);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights61() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 07);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 10);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights62() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 8);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 10);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights63() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 9);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 10);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 0, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights64() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 7);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights65() {
		LocalDate checkIn = LocalDate.of(2020, Month.DECEMBER, 31);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 7);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights66() {
		LocalDate checkIn = LocalDate.of(2020, Month.DECEMBER, 31);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 8);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights67() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 1);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 8);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights68() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 5);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 11);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights69() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 6);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 13);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights70() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 6);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights71() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 6);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights72() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 19);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 25);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights73() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 6);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 3, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights74() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 7);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 14);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights75() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 7);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 2, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights76() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 8);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 15);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 1, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights77() {
		LocalDate checkIn = LocalDate.of(2021, Month.JANUARY, 12);
		LocalDate checkOut = LocalDate.of(2021, Month.JANUARY, 18);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights78() {
		LocalDate checkIn = LocalDate.of(2019, Month.DECEMBER, 31);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 6);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights79() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 7);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 13);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}

	@Test
	void testNights80() {
		LocalDate checkIn = LocalDate.of(2020, Month.JANUARY, 14);
		LocalDate checkOut = LocalDate.of(2020, Month.JANUARY, 20);

		Travel travel = service.insert(new TravelRequest(checkIn, checkOut)).get();
		int[] expecteds = new int[] { 0, 1, 0 };
		int[] actuals = new int[] { travel.getExtraNightsBefore(), travel.getWeeks(), travel.getExtraNightsAfter() };

		assertArrayEquals(expecteds, actuals);

	}
}
