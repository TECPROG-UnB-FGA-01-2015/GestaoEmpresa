/***********************************************************
 * File: Transaction.java
 * Purpose: Gets the Transaction's info to sell Products.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Transaction
{
	protected ArrayList<Product> saleList;  // Stores and protects the Product's sale list
	protected double price; // Stores and protects the Transaction's price from a Product Purchase/Sale
	protected Employee employee; // Stores and protects the employee object from the Employee' class
	protected int day; // Stores and protects the Transaction's day from a Product Purchase/Sale
	protected int month; // Stores and protects the Transaction's month from a Product Purchase/Sale
	protected int year; // Stores and protects the Transaction's year from a Product Purchase/Sale

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Transaction's objects as self references */
	public Transaction(ArrayList<Product> saleList,  // Stores the Product's sale list
	                   double price, // Stores the Transaction's price  from a Product Purchase/Sale
	                   Employee employee, // Stores the employee object from the Employee' class
	                   int day, // Stores the Transaction's day from a Product Purchase/Sale
	                   int month, // Stores the Transaction's month from a Product Purchase/Sale
	                   int year) // Stores the Transaction's year from a Product Purchase/Sale
	{
		this.saleList = saleList;
		this.price = price;
		this.employee = employee;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// This method is responsible to access the saleList's protected value from the Produtc's ArrayList
	public ArrayList<Product> getSaleList()
	{
		return saleList;
	}

	// This method is responsible to modify the saleList's protected value from the Product's ArrayList
	public void setSaleList(ArrayList<Product> saleList)
	{
		this.saleList = saleList;
	}

	// This method is responsible to access the price's value
	public double getPrice()
	{
		return price;
	}

	// This method is responsible to modify the price's value
	public void setPrice(double price)
	{
		this.price = price;
	}

	// This method is responsible to access the employee's value
	public Employee getEmployee()
	{
		return employee;
	}

	// This method is responsible to modify the employee's value
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	// This method is responsible to access the day's value
	public int getDay()
	{
		return day;
	}

	// This method is responsible to modify the day's value
	public void setDay(int day)
	{
		this.day = day;
	}

	// This method is responsible to access the month's value
	public int getMonth()
	{
		return month;
	}

	// This method is responsible to modify the month's value
	public void setMonth(int month)
	{
		this.month = month;
	}

	// This method is responsible to access the year's value
	public int getYear()
	{
		return year;
	}

	// This method is responsible to modify the year's value
	public void setYear(int year)
	{
		this.year = year;
	}
}
