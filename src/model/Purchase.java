/***********************************************************
 * File: Purchase.java
 * Purpose: Responsible to get the Supplier's info to
 * 			buy Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Purchase extends Transaction
{
	private Supplier supplier; // Describes the supplier of the purchase

    // Constructor to receive all the attributes as parameters and initialize the object Purchase
	public Purchase(Supplier supplier,
	                ArrayList<Product> saleList, // Describes the sale list of the product
	                double price, // Describes the price of the purchase (value >= 0; example: 74,90)
	                Employee employee, // Describes the employee of the purchase
	                int day, // Describes the day of the purchase (1 <= day <= 31)
	                int month, // Describes the month of the purchase (1 <= day <= 12)
	                int year) // Describes the year of the purchase (2000 <= year <= 2015)
	{
		super(saleList, price, employee, day, month, year);
		this.supplier = supplier;
	}

    // Access and returns the Supplier
	public Supplier getSupplier()
	{
		return supplier;
	}

    // Sets a new value for the Supplier
	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}
}
