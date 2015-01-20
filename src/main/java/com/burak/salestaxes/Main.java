package com.burak.salestaxes;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.burak.salestaxes.InvalidInputException;

public class Main {

	public static void main(String[] args) {
		CreateList createList = null;
		Output output = null;
		createList = new CreateList("Inputs/input1.txt");

		if (createList != null) {
			try {
				output = createList.performTransaction();
				output.print();
				
			} catch (InvalidInputException invalidInputException) {
				System.out.println("Please check your input file for correct format");
			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("The file you specified, doesn't exist!");

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("List Not Available");

	}
}