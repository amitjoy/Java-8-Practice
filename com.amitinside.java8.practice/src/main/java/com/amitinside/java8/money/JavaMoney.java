package com.amitinside.java8.money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public final class JavaMoney {

	public static void main(final String[] args) {
		final CurrencyUnit currencyUnit = Monetary.getCurrency("INR");
		currencyUnit.getCurrencyCode();
		currencyUnit.getNumericCode();
		final int fractionDigits = currencyUnit.getDefaultFractionDigits();// 2
		System.out.println(fractionDigits);
	}

}
