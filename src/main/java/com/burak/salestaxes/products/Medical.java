package com.burak.salestaxes.products;

import com.burak.salestaxes.Constants;

public class Medical extends Product {

	private double salesTaxPercent = Constants.SALES_TAX_FOR_MEDICAL;

	public Medical(String name, double cost, int quantity, boolean isImported) {
		super(name, cost, quantity, isImported);
		super.setSalesTaxPercent(this.salesTaxPercent);
	}

}
