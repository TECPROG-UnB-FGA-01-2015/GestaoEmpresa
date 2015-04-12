/***********************************************************
 * File: Transaction.java
 * Purpose: Gets the Transaction's info to sell Products.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Transaction
{
	protected ArrayList<Produto> saleList;
	protected double transactionPrice;
	protected Funcionario employee;
	protected int transactionDay;
	protected int transactionMonth;
	protected int transactionYear;

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Transaction's objects as self references */
	public Transaction(ArrayList<Produto> saleList,
	                 double transactionPrice,
	                 Funcionario employee,
	                 int transactionDay,
	                 int transactionMonth,
	                 int transactionYear)
	{
		this.saleList = saleList;
		this.transactionPrice = transactionPrice;
		this.employee = employee;
		this.transactionDay = transactionDay;
		this.transactionMonth = transactionMonth;
		this.transactionYear = transactionYear;
	}

	// This method is responsible to access the saleList's protected value from the Produtc's ArrayList
	public ArrayList<Produto> getSaleList()
	{
		return saleList;
	}

	// This method is responsible to modify the saleList's protected value from the Product's ArrayList
	public void setSaleList(ArrayList<Produto> saleList)
	{
		this.saleList = saleList;
	}

	// This method is responsible to access the price's value
	public double getTransactionPrice()
	{
		return transactionPrice;
	}

	// This method is responsible to modify the price's value
	public void setTranscationPrice(double transactionPrice)
	{
		this.transactionPrice = transactionPrice;
	}

	// This method is responsible to access the employee's value
	public Funcionario getEmployee()
	{
		return employee;
	}

	// This method is responsible to modify the employee's value
	public void setEmployee(Funcionario employee)
	{
		this.employee = employee;
	}

	// This method is responsible to access the day's value
	public int getTransactionDay()
	{
		return transactionDay;
	}

	// This method is responsible to modify the day's value
	public void setTransactionDay(int transactionDay)
	{
		this.transactionDay = transactionDay;
	}

	// This method is responsible to access the month's value
	public int getTransactionMonth()
	{
		return transactionMonth;
	}

	// This method is responsible to modify the month's value
	public void setTransactionMonth(int transactionMonth)
	{
		this.transactionMonth = transactionMonth;
	}

	// This method is responsible to access the year's value
	public int getTransactionYear()
	{
		return transactionYear;
	}

	// This method is responsible to modify the year's value
	public void setTransactionYear(int transactionYear)
	{
		this.transactionYear = transactionYear;
	}

}
