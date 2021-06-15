package com.pchara.app.calculus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculusApplicationTests {

	@Autowired
	private CalculusController controller;

	@Test
	void sum() throws Exception {
		controller.sum(1, 2).getBody().result.equals(3);
	}

	@Test
	void sub() throws Exception {
		controller.sub(1, 2).getBody().result.equals(-1);
	}

	@Test
	void multiply() throws Exception {
		controller.multiply(5, 2).getBody().result.equals(20);
	}

	@Test
	void division() throws Exception {
		controller.division(10, 2).getBody().result.equals(5);
	}

	@Test
	void pow() throws Exception {
		controller.pow(2, 4).getBody().result.equals(16);
	}

}
