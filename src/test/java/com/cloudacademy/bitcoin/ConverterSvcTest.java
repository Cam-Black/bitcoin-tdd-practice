package com.cloudacademy.bitcoin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterSvcTest {
	
	@Test
	public void getExchangeRateUSDReturnsUSDExchangeRate() {
		//Arrange
		ConverterSvc converterSvc = new ConverterSvc();
		
		//Act
		double actual = converterSvc.getExchangeRate("USD");
		//Assert
		double expected = 100;
		assertEquals(expected, actual);
	}
}
