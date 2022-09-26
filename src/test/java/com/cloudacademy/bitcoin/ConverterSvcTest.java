package com.cloudacademy.bitcoin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterSvcTest {
	//Arrange
	ConverterSvc converterSvc;
	
	@BeforeEach
	public void init() {
		converterSvc = new ConverterSvc();
	}
	
	@Test
	public void getExchangeRate_USD_ReturnsUSDExchangeRate() {
		//Act
		double actual = converterSvc.getExchangeRate("usd");
		
		//Assert
		double expected = 100;
		assertEquals(expected, actual);
	}
	
	@Test
	public void getExchangeRate_GBP_ReturnsGBPExchangeRate() {
		//Act
		double actual = converterSvc.getExchangeRate("gbp");
		
		//Assert
		double expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void getExchangeRate_EUR_ReturnsEURExchangeRate() {
		//Act
		double actual = converterSvc.getExchangeRate("eur");
		
		//Assert
		double expected = 300;
		assertEquals(expected, actual);
	}
}