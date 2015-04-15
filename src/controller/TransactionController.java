/***********************************************************
 * File: TranscationController.java
 * Purpose: Responsible to get the Transaction's info to
 * 			add, remove and list Products sales.
 ***********************************************************/

package controller;

import java.util.ArrayList;
import model.Transaction;

public class TransactionController
{
	private ArrayList<Transaction> saleList; // Stores the Transcation's sale list

	/* This method is responsible to create a new ArrayList called saleList
	 * from the model class Transaction */
	public TransactionController()
	{
		this.saleList = new ArrayList<Transaction>();
	}

	// This method is responsible to access the saleList's private value from the ArrayList
	public ArrayList<Transaction> getSaleList()
	{
		return saleList;
	}

	// This method is responsible to modify the saleList's private value from the ArrayList
	public void setSaleList(ArrayList<Transaction> saleList)
	{
		this.saleList = saleList;
	}

	/* This method is responsible to add sales on the saleList's arraylist on
	 * the model class Transaction */
	public void addSale(Transaction sale)
	{
		saleList.add(sale);
	}

	/* This method is responsible to delete the added sales on the saleList's
	 * arraylist on the model class Transaction */
	public void removeSale(Transaction sale)
	{
		saleList.remove(sale);
	}

}
