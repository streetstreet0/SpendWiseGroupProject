package backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DateTest {

	@Test
	void test1() {
		String fullDate = "7/1/2000";
		Date date = new Date(07, 01, 2000);
		assertEquals(fullDate, date.toString());
	}

	@Test
	void test2() {
		String fullDate = "18/9/2022";
		Date date = new Date(18, 9, 2022);
		assertEquals(fullDate, date.toString());
	}

}
