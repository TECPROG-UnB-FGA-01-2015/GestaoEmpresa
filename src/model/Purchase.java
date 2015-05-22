/***********************************************************
 * File: Purchase.java
 * Purpose: Responsible to get the Supplier's info to
 * 			buy Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Purchase extends Transaction
{
	private Supplier supplier; // Stores the supplier object from the Supplier' class

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Purchase's objects and to call the parent
	 * constructor (superclass) from Transaction class with its arguments */
	public Purchase(Supplier supplier,
	                ArrayList<Product> saleList, // Stores the Product's sale list
	                double price, // Stores the Product's price
	                Employee employee, // Stores the employee object from the Employee' class
	                int day, // Stores the Product's day purchase
	                int month, // Stores the Product's month purchase
	                int year) // Stores the Product's year purchase
	{
		super(saleList, price, employee, day, month, year);
		this.supplier = supplier;
	}

	// This method is responsible to access the Supplier's private value
	public Supplier getSupplier()
	{
		return supplier;
	}

	// This method is responsible to modify the Supplier's private value
	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}
}
