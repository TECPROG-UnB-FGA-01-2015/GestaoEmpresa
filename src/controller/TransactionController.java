/***********************************************************
 * File: TransactionController.java
 * Purpose: Gets the Transaction's info to add, remove and 
 * 			list Products sales and purchases.
 ***********************************************************/

package controller;

import java.util.ArrayList;
import model.Transaction;

public class TransactionController
{
	private ArrayList<Transaction> saleList; // Stores the Transaction's sale list

	// Constructor to instance TransactionController initializing the attribute saleList
	public TransactionController()
	{
		this.saleList = new ArrayList<Transaction>();
	}

	// Access the saleList and return all the sales and purchases
	public ArrayList<Transaction> getSaleList()
	{
		return saleList;
	}

	// Sets a new list for the saleList
	public void setSaleList(ArrayList<Transaction> saleList)
	{
		this.saleList = saleList;
	}

	// Adds sale to the saleList
	public void addSale(Transaction sale)
	{
		saleList.add(sale);
	}

	// Deletes sales from the saleList
	public void removeSale(Transaction sale)
	{
		saleList.remove(sale);
	}
}
