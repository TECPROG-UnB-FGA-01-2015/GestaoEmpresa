/**********************************************************
 * File: Sale.java
 * Purpose: Responsible to get the Client's info to
 * 			sell Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Sale extends Transaction
{
	private Client client; // Describes the Client of the sale

    // Constructor to receive all the attributes as parameters and initialize the object Sale
	public Sale(Client client,
	            ArrayList<Product> saleList, // Describes the sale list of the product
	            double price, // Describes the price of the sale (value >= 0; example: 74,90)
	            Employee employee, // Describes the employee of the sale
	            int day, // Describes the day of the sale (1 <= day <= 31)
	            int month, // Describes the month of the sale (1 <= day <= 12)
	            int year) // Describes the year of the sale (2000 <= year <= 2015)
	{
		super(saleList, price, employee, day, month, year);
		this.client = client;
	}

    // Access and returns the Client
	public Client getClient()
	{
		return client;
	}

    // Sets a new value for the Client
	public void setClient(Client client)
	{
		this.client = client;
	}
}
