package com.burak.salestaxes.products;

import com.burak.salestaxes.Constants;
public class Book extends Product {

	private double salesTaxPercent = Constants.SALES_TAX_FOR_BOOKS;
	
	public Book(String title, double cost, int quantity, boolean isImported) {
		super(title, cost, quantity, isImported);
		super.setSalesTaxPercent(this.salesTaxPercent);
		
	}

}
