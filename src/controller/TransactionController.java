/***********************************************************
 * File: TransactionController.java
 * Purpose: Gets the Transaction's info to add, remove and 
 * 			list products' sales and purchases.
 ***********************************************************/

package controller;

import java.util.ArrayList;
import model.Transaction;

public class TransactionController
{
	private ArrayList<Transaction> transactionList; // Describes a list of transactions

	// Constructor to initialize the controller of transactions with a transaction list
	public TransactionController()
	{
		this.transactionList = new ArrayList<Transaction>();
	}

	// Access the saleList and return all the sales and purchases
	public ArrayList<Transaction> getTransactionList()
	{
		return transactionList;
	}

	// Sets a new list for the saleList or purchaseList
	public void setTransactionList(ArrayList<Transaction> transactionList)
	{
		this.transactionList = transactionList;
	}

	// Adds sale or purchase to the saleList or purchaseList
	public void addTransaction(Transaction transaction)
	{
		transactionList.add(transaction);
	}

	// Removes sale or purchase from the saleList or purchaseList
	public void removeTransaction(Transaction transaction)
	{
		transactionList.remove(transaction);
	}
}
