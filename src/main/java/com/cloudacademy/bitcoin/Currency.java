package com.cloudacademy.bitcoin;

public enum Currency {
	USD("USD"),
	GBP("GBP"),
	EUR("EUR");
	
	private final String currency;
	
	Currency(String currency) {
		this.currency = currency;
	}
	
	String getCurrency() {
		return this.currency;
	}
	
}
