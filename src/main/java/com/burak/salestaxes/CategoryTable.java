package com.burak.salestaxes;

import java.util.HashMap;

import com.burak.salestaxes.Constants;

public class CategoryTable {

	private static CategoryTable instance;
	private static HashMap<String, String> itemCategoriesMap;

	public static CategoryTable getInstance() {
		if (instance == null) {
			instance = new CategoryTable();
		}
		return instance;
	}

	private CategoryTable() {
		itemCategoriesMap = new HashMap<String, String>();
		itemCategoriesMap.put("book", Constants.OFFICE_SUPPLIES);
		itemCategoriesMap.put("books", Constants.OFFICE_SUPPLIES);
		itemCategoriesMap.put("chocolate", Constants.FOOD_PRODUCT);
		itemCategoriesMap.put("chocolates", Constants.FOOD_PRODUCT);
		itemCategoriesMap.put("music", Constants.OTHER);
		itemCategoriesMap.put("perfume", Constants.OTHER);
		itemCategoriesMap.put("pills", Constants.MEDICAL_PRODUCT);
	}

	public void addProduct(String item, String category) {
		itemCategoriesMap.put(item, category);
	}
	//create category with using productDescription's array
	public String getCategoryFor(String productDescription) {
		String[] productKeyWords = productDescription.split(" ");
		String category = Constants.OTHER;
		for (int keyWordIndex = 0; keyWordIndex < productKeyWords.length; keyWordIndex++) {
			if (itemCategoriesMap.containsKey(productKeyWords[keyWordIndex])) {
				category = itemCategoriesMap.get(productKeyWords[keyWordIndex]);
			}
		}
		return category;
	}
}
