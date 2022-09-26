package com.cloudacademy.bitcoin;

public class ConverterSvc {
	public ConverterSvc() {
		super();
	}
	
	public int getExchangeRate(String currency) {
		if (currency.equalsIgnoreCase("usd")) {
			return 100;
		} else if (currency.equalsIgnoreCase("gbp")) {
			return 200;
		} else if (currency.equalsIgnoreCase("eur")) {
			return 300;
		}
		return 0;
	}
}
