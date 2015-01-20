package com.burak.salestaxes.products;

import com.burak.salestaxes.Constants;

public class Food extends Product {

	private double salesTaxPercent = Constants.SALES_TAX_FOR_FOOD;

	public Food(String name, double cost, int quantity, boolean isImported) {
		super(name, cost, quantity, isImported);
		super.setSalesTaxPercent(this.salesTaxPercent);
	}

}
