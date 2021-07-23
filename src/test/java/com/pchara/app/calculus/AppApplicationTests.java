package com.pchara.app.calculus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pchara.app.calculus.rest.CalculusController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CalculusApplicationTests {

	@Autowired
	private CalculusController controller;

	@Test
	void sum() throws Exception {
		assertEquals(controller.sum(1.0, 2.2, null).getBody().getResult(), 3.2);
	}

	@Test
	void sub() throws Exception {
		assertEquals(controller.sub(2.0, 1.0, null).getBody().getResult(), 1.0);
	}

	@Test
	void multiply() throws Exception {
		assertEquals(controller.multiply(5.0, 2.0, null).getBody().getResult(), 10.0);
	}

	@Test
	void division() throws Exception {
		assertEquals(controller.division(10.0, 2.0, null).getBody().getResult(), 5.0);
	}

	@Test
	void pow() throws Exception {
		assertEquals(controller.pow(2.0, 4.0, null).getBody().getResult(), 16.0);
	}

}
