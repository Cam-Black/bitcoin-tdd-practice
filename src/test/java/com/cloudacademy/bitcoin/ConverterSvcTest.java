package com.cloudacademy.bitcoin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterSvcTest {
	
	@Test
	public void getExchangeRate_USD_ReturnsUSDExchangeRate() {
		//Arrange
		ConverterSvc converterSvc = new ConverterSvc();
		
		//Act
		double actual = converterSvc.getExchangeRate("usd");
		
		//Assert
		double expected = 100;
		assertEquals(expected, actual);
	}
	
	@Test
	public void getExchangeRate_GBP_ReturnsGBPExchangeRate() {
		//Arrange
		ConverterSvc converterSvc = new ConverterSvc();
		
		//Act
		double actual = converterSvc.getExchangeRate("gbp");
		
		//Assert
		double expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void getExchangeRate_EUR_ReturnsEURExchangeRate() {
		//Arrange
		ConverterSvc converterSvc = new ConverterSvc();
		
		//Act
		double actual = converterSvc.getExchangeRate("eur");
		
		//Assert
		double expected = 300;
		assertEquals(expected, actual);
	}
}
