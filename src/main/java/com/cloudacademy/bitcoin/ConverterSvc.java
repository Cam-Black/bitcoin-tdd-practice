package com.cloudacademy.bitcoin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class ConverterSvc {
	
	private final String BITCOIN_CURRPRICE_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	private final HttpGet httpGet = new HttpGet(BITCOIN_CURRPRICE_URL);
	
	private final CloseableHttpClient httpClient;
	
	public ConverterSvc() {
		super();
		this.httpClient = HttpClients.createDefault();
	}
	
	public ConverterSvc(CloseableHttpClient client) {
		super();
		this.httpClient = client;
	}
	
	public double getExchangeRate(Currency currency) {
		double rate;
		try (CloseableHttpResponse response = this.httpClient.execute(httpGet)) {
			
			InputStream inputStream = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			
			JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();
			String n =
					jsonObject.get("bpi").getAsJsonObject().get(currency.getCurrency()).getAsJsonObject().get("rate").getAsString();
			NumberFormat nf = NumberFormat.getInstance();
			rate = nf.parse(n).doubleValue();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			rate = 0;
		}
		return rate;
	}
	
	public double convertBitcoins(Currency currency, double coins) {
		if (coins < 0) {
			throw new IllegalArgumentException("Coins can't be less than 0");
		}
		return coins * getExchangeRate(currency);
	}
	
	public static void main(String[] args) {
		ConverterSvc converter = new ConverterSvc();
		System.out.println(converter.convertBitcoins(Currency.GBP, 2));
	}
}
