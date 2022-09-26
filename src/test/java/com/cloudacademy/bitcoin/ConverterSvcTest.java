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
	
	@Test
	public void convertBitcoins_1BitCoinToUSD_ReturnsUSDollars() {
		//Act
		double actual = converterSvc.convertBitcoins("usd", 1);
		
		//Assert
		double expected = 100;
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertBitcoins_2BitCoinToUSD_ReturnsUSDollars() {
		//Act
		double actual = converterSvc.convertBitcoins("usd", 2);
		
		//Assert
		double expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertBitcoins_1BitCoinToGBP_ReturnsGBPounds() {
		//Act
		double actual = converterSvc.convertBitcoins("gbp", 1);
		
		//Assert
		double expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertBitcoins_2BitCoinToGBP_ReturnsGBPounds() {
		//Act
		double actual = converterSvc.convertBitcoins("gbp", 2);
		
		//Assert
		double expected = 400;
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertBitcoins_1BitCoinToEUR_ReturnsEuros() {
		//Act
		double actual = converterSvc.convertBitcoins("eur", 1);
		
		//Assert
		double expected = 300;
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertBitcoins_2BitCoinToEUR_ReturnsEuros() {
		//Act
		double actual = converterSvc.convertBitcoins("eur", 2);
		
		//Assert
		double expected = 600;
		assertEquals(expected, actual);
	}
}