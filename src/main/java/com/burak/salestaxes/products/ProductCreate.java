package com.burak.salestaxes.products;

import com.burak.salestaxes.Constants;

public class ProductCreate {

	private static ProductCreate instance;

	public static ProductCreate getInstance() {
		if (instance == null) {
			instance = new ProductCreate();
		}
		return instance;
	}

	private ProductCreate() {

	}
	public Product createProduct(String productType, String name, double cost, int quantity,
			boolean isImported) {

		Product product = null;

		if (productType.equals(Constants.OFFICE_SUPPLIES)) {
			product = new Book(name, cost, quantity, isImported); // Create product from Book class
		} else if (productType.equals(Constants.FOOD_PRODUCT)) {
			product = new Food(name, cost, quantity, isImported);
		} else if (productType.equals(Constants.MEDICAL_PRODUCT)) {
			product = new Medical(name, cost, quantity, isImported);
		} else {
			product = new Other(name, cost, quantity, isImported);
		}

		return product;
	}

}
