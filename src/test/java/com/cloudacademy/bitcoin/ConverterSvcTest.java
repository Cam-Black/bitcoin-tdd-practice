package com.cloudacademy.bitcoin;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ConverterSvcTest {
	ConverterSvc converterSvc;
	
	private CloseableHttpClient client;
	private CloseableHttpResponse response;
	private StatusLine statusLine;
	private HttpEntity entity;
	private InputStream stream;
	
	//Setup required to allow for mocking.
	@BeforeEach
	public void init() {
		client = mock(CloseableHttpClient.class);
		response = mock(CloseableHttpResponse.class);
		statusLine = mock(StatusLine.class);
		entity = mock(HttpEntity.class);
		
		stream =
				new ByteArrayInputStream(
						("{\"time\": {\"updated\": \"Oct 15, 2020 22:55:00 UTC\",\"updatedISO\": " +
								"\"2020-10-15T22:55:00+00:00\",\"updateduk\": \"Oct 15, 2020 at 23:55 BST\"}," +
								"\"chartName\": \"Bitcoin\",\"bpi\": {\"USD\": {\"code\": \"USD\",\"symbol\": \"&#36;" +
								"\",\"rate\": \"11,486.5341\",\"description\": \"United States Dollar\"," +
								"\"rate_float\": 11486.5341},\"GBP\": {\"code\": \"GBP\",\"symbol\": \"&pound;\"," +
								"\"rate\": \"8,900.8693\",\"description\": \"British Pound Sterling\",\"rate_float\": " +
								"8900.8693},\"EUR\": {\"code\": \"EUR\",\"symbol\": \"&euro;\",\"rate\": \"9,809" +
								".3278\",\"description\": \"Euro\",\"rate_float\": 9809.3278}}}").getBytes());
		 converterSvc = new ConverterSvc(client);
	}
	
	@Test
	public void getExchangeRate_USD_ReturnsUSDExchangeRate() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.getExchangeRate(Currency.USD);
		
		//Assert
		double expected = 11486.5341;
		assertEquals(expected, actual);
	}
	
	@Test
	public void getExchangeRate_GBP_ReturnsGBPExchangeRate() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.getExchangeRate(Currency.GBP);

		//Assert
		double expected = 8900.8693;
		assertEquals(expected, actual);
	}

	@Test
	public void getExchangeRate_EUR_ReturnsEURExchangeRate() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.getExchangeRate(Currency.EUR);

		//Assert
		double expected = 9809.3278;
		assertEquals(expected, actual);
	}

	@Test
	public void convertBitcoins_1BitCoinToUSD_ReturnsUSDollars() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.convertBitcoins(Currency.USD, 1);

		//Assert
		double expected = 11486.5341;
		assertEquals(expected, actual);
	}

	@Test
	public void convertBitcoins_2BitCoinToUSD_ReturnsUSDollars() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.convertBitcoins(Currency.USD, 2);

		//Assert
		double expected = 11486.5341 * 2;
		assertEquals(expected, actual);
	}

	@Test
	public void convertBitcoins_1BitCoinToGBP_ReturnsGBPounds() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.convertBitcoins(Currency.GBP, 1);

		//Assert
		double expected = 8900.8693;
		assertEquals(expected, actual);
	}

	@Test
	public void convertBitcoins_2BitCoinToGBP_ReturnsGBPounds() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.convertBitcoins(Currency.GBP, 2);

		//Assert
		double expected = 8900.8693 * 2;
		assertEquals(expected, actual);
	}

	@Test
	public void convertBitcoins_1BitCoinToEUR_ReturnsEuros() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.convertBitcoins(Currency.EUR, 1);

		//Assert
		double expected = 9809.3278;
		assertEquals(expected, actual);
	}

	@Test
	public void convertBitcoins_2BitCoinToEUR_ReturnsEuros() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act
		double actual = converterSvc.convertBitcoins(Currency.EUR, 2);

		//Assert
		double expected = 9809.3278 * 2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void getExchangeRate_ThrowsException() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		doThrow(IOException.class).when(response).close();
		
		//Act
		double actual = converterSvc.getExchangeRate(Currency.EUR);
		
		//Assert
		double expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertBitCoins_NegativeCoins_ThrowsException() throws IOException {
		//Arrange
		Mockito.when(statusLine.getStatusCode()).thenReturn(200);
		Mockito.when(response.getStatusLine()).thenReturn(statusLine);
		Mockito.when(response.getEntity()).thenReturn(entity);
		Mockito.when(entity.getContent()).thenReturn(stream);
		Mockito.when(client.execute(any(HttpGet.class))).thenReturn(response);
		
		//Act and Assert
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> converterSvc.convertBitcoins(Currency.GBP, -1));
	}
}