package com.burak.salestaxes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import com.burak.salestaxes.*;


public class InputTest {

	@Test
	public void testInput1() throws InvalidInputException, NumberFormatException, IOException {
		CreateList newClient = new CreateList("Inputs/input1.txt");
		Output receipt = newClient.performTransaction();
		BigDecimal total = receipt.getTotal();
		BigDecimal myTotal = new BigDecimal("29.83");
		assertTrue(total.equals(myTotal));
	}

	@Test
	public void testInput2() throws InvalidInputException, NumberFormatException, IOException {
		CreateList newClient = new CreateList("Inputs/input2.txt");
		Output receipt = newClient.performTransaction();
		BigDecimal total = receipt.getTotal();
		BigDecimal myTotal = new BigDecimal("65.15");
		assertTrue(total.equals(myTotal));
	}

	@Test
	public void testInput3() throws InvalidInputException, NumberFormatException, IOException {
		CreateList newClient = new CreateList("Inputs/input3.txt");
		Output receipt = newClient.performTransaction();
		BigDecimal total = receipt.getTotal();
		BigDecimal myTotal = new BigDecimal("74.68");
		assertTrue(total.equals(myTotal));
	}

}
