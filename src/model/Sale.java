/***********************************************************
 * File: Sale.java
 * Purpose: Responsible to get the Client's info to
 * 			sell Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Sale extends Transaction
{
	private Cliente client;

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Sale's objects and to call the parent
	 * constructor (superclass) from Transaction class with its arguments */
	public Sale(Cliente client,
	             ArrayList<Produto> saleList,
	             double salePrice,
	             Funcionario employee,
	             int saleDay,
	             int saleMonth,
	             int saleYear)
	{
		super(saleList, salePrice, employee, saleDay, saleMonth, saleYear);
		this.client = client;
	}

	// This method is responsible to access the Client's private value
	public Cliente getClient()
	{
		return client;
	}

	// This method is responsible to modify the Client's private value
	public void setClient(Cliente client)
	{
		this.client = client;
	}
}
