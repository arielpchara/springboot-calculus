package com.pchara.app.calculus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pchara.app.calculus.rest.CalculusController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CalculusApplicationTests {

	private final CalculusController calculusController;

	public CalculusApplicationTests(CalculusController calculusController) {
		this.calculusController = calculusController;
	}

	@Test
	void sum() throws Exception {
		assertEquals(calculusController.sum(1.0, 2.2, null).getBody().getResult(), 3.2);
	}

	@Test
	void sub() throws Exception {
		assertEquals(calculusController.sub(2.0, 1.0, null).getBody().getResult(), 1.0);
	}

	@Test
	void multiply() throws Exception {
		assertEquals(calculusController.multiply(5.0, 2.0, null).getBody().getResult(), 10.0);
	}

	@Test
	void division() throws Exception {
		assertEquals(calculusController.division(10.0, 2.0, null).getBody().getResult(), 5.0);
	}

	@Test
	void pow() throws Exception {
		assertEquals(calculusController.pow(2.0, 4.0, null).getBody().getResult(), 16.0);
	}

}
