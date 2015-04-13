/***********************************************************
 * File: Purchase.java
 * Purpose: Responsible to get the Supplier's info to
 * 			buy Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Purchase extends Transaction
{
	private Supplier supplier;

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Purchase's objects and to call the parent
	 * constructor (superclass) from Transaction class with its arguments */
	public Purchase(Supplier supplier,
	              ArrayList<Product> saleList,
	              double price,
	              Employee employee,
	              int day,
	              int month,
	              int year)
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
