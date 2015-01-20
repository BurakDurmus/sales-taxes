package com.burak.salestaxes.shoppingCart;

import java.util.Iterator;

import com.burak.salestaxes.products.Product;

public interface ShoppingList {

	void addProduct(Product product);

	int getItemCount();

	Iterator iterator();

	void empty();
}