package com.burak.salestaxes.shoppingCart;

import java.util.ArrayList;
import java.util.Iterator;

import com.burak.salestaxes.products.Product;

public class AddingList implements ShoppingList {


	private ArrayList<Product> box;
	private static Iterator<Product> iterator;

	public AddingList() {
		
		box = new ArrayList<Product>();

	}

	public void addProduct(Product product) {
		box.add(product);
	}

	public int getItemCount() {
		return box.size();
	}

	public Iterator iterator() {
		return box.iterator();
	}

	public void empty() {
		box.clear();
	}
}