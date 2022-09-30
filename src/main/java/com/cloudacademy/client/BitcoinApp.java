package com.cloudacademy.client;

import com.cloudacademy.bitcoin.ConverterSvc;
import com.cloudacademy.bitcoin.Currency;

import java.util.Scanner;

public class BitcoinApp {
	public void runInConsole() {
		Scanner scan = new Scanner(System.in);
		ConverterSvc converter = new ConverterSvc();
		boolean run = true;
		String coins;
		String currencyAsString;
		
		System.out.println("A system for converting Bitcoins into US Dollars, Great British Pounds, or Euros!");
		while (run) {
			System.out.println("To Exit, simply type exit at any time");
			do {
				System.out.print("Coins: ");
				coins = scan.nextLine();
			} while (coins.isEmpty());
			
			if (coins.equalsIgnoreCase("exit")) {
				break;
			}
			do {
				System.out.print("Currency, (USD, GBP, EUR): ");
				currencyAsString = scan.nextLine();
			} while (currencyAsString.isEmpty());
			
			currencyAsString = currencyAsString.toUpperCase();
			if (currencyAsString.equalsIgnoreCase("exit")) {
				break;
			}
			Currency currency = Currency.valueOf(currencyAsString);
			double convertedPrice = converter.convertBitcoins(currency, Double.parseDouble(coins));
			
			System.out.println(coins + " bitcoins in " + currency + " = " + convertedPrice);
		}
	}
}
