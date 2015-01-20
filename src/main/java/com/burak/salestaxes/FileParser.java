package com.burak.salestaxes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.burak.salestaxes.InvalidInputException;

public class FileParser {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String filePath;
	private ArrayList<InputData> inputDataArray;

	public FileParser(String filePath) throws InvalidInputException, NumberFormatException,
			IOException {
		this.filePath = filePath;
		this.inputDataArray = new ArrayList<InputData>();
		fileReader = new FileReader(filePath);
		bufferedReader = new BufferedReader(fileReader);
		String currentLine = null;
		int quantity = 0;
		double cost = 0;
		while ((currentLine = bufferedReader.readLine()) != null) {
			// remove trailing spaces
			currentLine = currentLine.replaceAll("\\s+$", "");
			String[] array = currentLine.split(" ");

			// the line should start and end with a number
			if (isNumber(array[0]) && isNumber(array[array.length - 1])) {
				quantity = new Integer(array[0]).intValue();
				cost = new Double(array[array.length - 1]).doubleValue();
			} else {
				quantity = 0;
				cost = 0;
				throw new InvalidInputException();
			}

			// create an array of keywords from the product description
			String[] product = Arrays.copyOfRange(array, 1, array.length - 2);
			String productDescription = "";
			for (int index = 0; index < product.length; index++) {
				productDescription += " " + product[index].toLowerCase();
			}

			boolean isImported = productDescription.contains("imported");
			String productName = productDescription.replaceAll("imported", "");
			// adding data to InputData with all properties 
			inputDataArray.add(new InputData(quantity, productName, isImported, cost));
		}

	}

	private boolean isNumber(String fileInputString) {
		boolean isNumber = true;
		try {
			isNumber = (Double.parseDouble(fileInputString)) > 0;
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		return isNumber;
	}

	public ArrayList<InputData> getInputData() {
		return inputDataArray;

	}
}