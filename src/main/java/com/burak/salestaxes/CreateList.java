package com.burak.salestaxes;

import java.io.IOException;
import java.util.ArrayList;

import com.burak.salestaxes.InvalidInputException;
import com.burak.salestaxes.products.Product;
import com.burak.salestaxes.products.ProductCreate;
import com.burak.salestaxes.shoppingCart.AddingList;
import com.burak.salestaxes.shoppingCart.ShoppingList;

public class CreateList {
	CategoryTable category_table;
	ArrayList<InputData> inputData;
	ProductCreate productCreate;
	ShoppingList shoppingList;
	Output output;

	private String inputFilePath;

	public CreateList(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	public Output performTransaction()
			throws InvalidInputException, NumberFormatException, IOException {
		// read and prepare input data
		category_table = CategoryTable.getInstance();

		inputData = new FileParser(inputFilePath).getInputData();
		productCreate = ProductCreate.getInstance();
		shoppingList = new AddingList();
		// for the coming datas will create specific product and adding lists
		for (InputData data : inputData) {
			int quantity = data.getQuantity();
			String productDescription = data.getProductDescription();
			double cost = data.getCost();
			boolean isImported = data.isImported();
			String category = category_table.getCategoryFor(productDescription);
			// getting data to variables and creating product
			Product product = productCreate.createProduct(category, productDescription, cost,
					quantity, isImported);
			shoppingList.addProduct(product);
		}

		output = new Output(shoppingList);
		return output;
	}
}