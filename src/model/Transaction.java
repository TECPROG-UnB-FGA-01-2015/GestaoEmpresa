/***********************************************************
 * File: Transaction.java
 * Purpose: Gets the Transaction's info to sell Products.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Transaction
{
	protected ArrayList<Product> saleList;  // Describes a list of products of the transaction
	protected double price; // Describes the price of the transaction (value >= 0; example: 74,90)
	protected Employee employee; // Describes the employee of the transaction
	protected int day; // Describes the day of the transaction (1 <= day <= 31)
	protected int month; // Describes the month of the transaction (1 <= day <= 12)
	protected int year; // Describes the year of the transaction (year < 0)

	// Constructor to receive all the attributes as parameters and initialize the object Transaction
	public Transaction(ArrayList<Product> saleList,
	                   double price,
	                   Employee employee,
	                   int day,
	                   int month,
	                   int year)
	{
		this.saleList = saleList;
		this.price = price;
		this.employee = employee;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Access and returns the saleList
	public ArrayList<Product> getSaleList()
	{
		return saleList;
	}

	// Sets a new value for the saleList
	public void setSaleList(ArrayList<Product> saleList)
	{
		this.saleList = saleList;
	}

	// Access and returns the property price
	public double getPrice()
	{
		return price;
	}

	// Sets a new value for the price property
	public void setPrice(double price)
	{
		this.price = price;
	}

	// Access and returns the Employee
	public Employee getEmployee()
	{
		return employee;
	}

	// Sets a new value for the Employee
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	// Access and returns the property day
	public int getDay()
	{
		return day;
	}

	// Sets a new value for the day property
	public void setDay(int day)
	{
		this.day = day;
	}

	// Access and returns the property month
	public int getMonth()
	{
		return month;
	}

	// Sets a new value for the month property
	public void setMonth(int month)
	{
		this.month = month;
	}

	// Access and returns the property year
	public int getYear()
	{
		return year;
	}

	// Sets a new value for the year property
	public void setYear(int year)
	{
		this.year = year;
	}
}
