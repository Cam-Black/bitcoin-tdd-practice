package com.cloudacademy.bitcoin;

public class ConverterSvc {
	public ConverterSvc() {
		super();
	}
	
	public double getExchangeRate(String currency) {
		if (currency.equalsIgnoreCase("usd")) {
			return 100;
		} else if (currency.equalsIgnoreCase("gbp")) {
			return 200;
		} else if (currency.equalsIgnoreCase("eur")) {
			return 300;
		}
		return 0;
	}
	
	public double convertBitcoins(String currency, double coins) {
		return coins * getExchangeRate(currency);
	}
}
