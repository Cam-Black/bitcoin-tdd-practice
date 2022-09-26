package com.cloudacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
	Calculator calc;
	
	@BeforeEach
	public void init() {
		calc = new Calculator();
	}
	
	@Test
	public void testAdd() {
		assertEquals(2, calc.add(1, 1));
	}
}
