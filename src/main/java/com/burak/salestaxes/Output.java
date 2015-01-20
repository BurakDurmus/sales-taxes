package com.burak.salestaxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import com.burak.salestaxes.products.Product;
import com.burak.salestaxes.shoppingCart.ShoppingList;

public class Output {

	private static class OutputItems {
		private int quantity;
		private String name;
		private BigDecimal totalCost;
		private BigDecimal salesTax;
		private boolean isImported;

		public OutputItems(int quantity, String name, double salesTax, double totalCost, boolean isImported) {
			this.quantity = quantity;
			this.name = name;
			this.salesTax = new BigDecimal(Double.toString(salesTax)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			this.totalCost = new BigDecimal(Double.toString(totalCost)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			this.isImported = isImported;
		}

	}

	private ArrayList<OutputItems> outputItemsList;
	private double salesTaxesTotal = 0;
	private double baseCostTotal = 0;
	private double overallTotal = 0;

	private ShoppingList list;

	public Output(ShoppingList list) {
		this.list = list;
		this.outputItemsList = new ArrayList<OutputItems>();
		generateOutput();
	}

	/** Get the total for this purchase */
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(Double.toString(overallTotal)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return total;
	}

	/** Get the total sales tax for this purchase */
	public BigDecimal getSalesTax() {

		BigDecimal salesTaxes = new BigDecimal(
				Double.toString(salesTaxesTotal)).setScale(2,BigDecimal.ROUND_HALF_EVEN);
		return salesTaxes;
	}

	/** Helper method that does all the calculations */
	private void generateOutput() {
		Iterator<Product> listIterator = list.iterator();

		while (listIterator.hasNext()) {
			Product product = listIterator.next();
			int quantity = product.getQuantity();
			String name = product.getName();
			boolean isImported = product.isImported();
			double totalBaseCostForThisProduct = product.getCost();
			double totalSalesTaxForThisProduct = product.getSalesTax();
			double totalCostForThisProduct = totalBaseCostForThisProduct + totalSalesTaxForThisProduct;

			salesTaxesTotal += totalSalesTaxForThisProduct;
			baseCostTotal += totalBaseCostForThisProduct;

			outputItemsList.add(new OutputItems(quantity, name, totalSalesTaxForThisProduct, totalCostForThisProduct, isImported));
		}

		overallTotal = baseCostTotal + salesTaxesTotal;
	}

	/*
	 * This method will print output
	 */
	public void print() {

		for (OutputItems item : outputItemsList) {
			System.out.print(item.quantity);
			if (item.isImported)
				System.out.print(" Imported ");
			System.out.println(item.name + " : " + item.totalCost);

		}

		System.out.println("\nSales Taxes: "
				+ new BigDecimal(Double.toString(salesTaxesTotal)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		System.out.println("Total: "
				+ new BigDecimal(Double.toString(overallTotal)).setScale(2, BigDecimal.ROUND_HALF_EVEN));

		list.empty();
	}
}