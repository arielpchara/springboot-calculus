package com.pchara.app.calculus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CalculusApplicationTests {

	@Autowired
	private CalculusController controller;

	@Test
	void sum() throws Exception {
		assertEquals(controller.sum("1", "2", null).getBody().result, 3.0);
	}

	@Test
	void sub() throws Exception {
		assertEquals(controller.sub("2", "1", null).getBody().result, 1.0);
	}

	@Test
	void multiply() throws Exception {
		assertEquals(controller.multiply("5", "2", null).getBody().result, 10.0);
	}

	@Test
	void division() throws Exception {
		assertEquals(controller.division("10", "2", null).getBody().result, 5.0);
	}

	@Test
	void pow() throws Exception {
		assertEquals(controller.pow("2", "4", null).getBody().result, 16.0);
	}

	@Test
	void history() throws Exception {
		assertEquals(controller.history().getBody().size(), 5);
	}

}
