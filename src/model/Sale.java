/**********************************************************
 * File: Sale.java
 * Purpose: Responsible to get the Client's info to
 * 			sell Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Sale extends Transaction
{
	private Client client; // Stores the client object from the Client' class

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Sale's objects and to call the parent
	 * constructor (superclass) from Transaction class with its arguments */
	public Sale(Client client,
	            ArrayList<Product> saleList, // Stores the Product's sale list
	            double price, // Stores the Product's sale price
	            Employee employee, // Stores the employee object from the Employee' class
	            int day, // Stores the Product's day sale
	            int month, // Stores the Product's month sale
	            int year) // Stores the Product's year sale
	{
		super(saleList, price, employee, day, month, year);
		this.client = client;
	}

	// This method is responsible to access the Client's private value
	public Client getClient()
	{
		return client;
	}

	// This method is responsible to modify the Client's private value
	public void setClient(Client client)
	{
		this.client = client;
	}
}
