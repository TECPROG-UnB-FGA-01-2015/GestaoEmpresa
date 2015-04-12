/***********************************************************
 * File: Transacao.java
 * Purpose: Gets the Transaction's info to sell Products.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Transaction
{
	protected ArrayList<Produto> saleList;
	protected double price;
	protected Funcionario employee;
	protected int day;
	protected int month;
	protected int year;

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Transacao's objects as self references */
	public Transaction(ArrayList<Produto> saleList,
	                 double price,
	                 Funcionario employee,
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

	// This method is responsible to access the listaVenda's protected value from the Produto's ArrayList
	public ArrayList<Produto> getSaleList()
	{
		return saleList;
	}

	// This method is responsible to modify the listaVenda's protected value from the Produto's ArrayList
	public void setsaleList(ArrayList<Produto> saleList)
	{
		this.saleList = saleList;
	}

	// This method is responsible to access the preco's value
	public double getPrice()
	{
		return price;
	}

	// This method is responsible to modify the preco's value
	public void setPrice(double price)
	{
		this.price = price;
	}

	// This method is responsible to access the funcionario's value
	public Funcionario getEmployee()
	{
		return employee;
	}

	// This method is responsible to modify the funcionario's value
	public void setEmployee(Funcionario employee)
	{
		this.employee = employee;
	}

	// This method is responsible to access the dia's value
	public int getDay()
	{
		return day;
	}

	// This method is responsible to modify the dia's value
	public void setDay(int day)
	{
		this.day = day;
	}

	// This method is responsible to access the mes's value
	public int getMonth()
	{
		return month;
	}

	// This method is responsible to modify the mes's value
	public void setMonth(int month)
	{
		this.month = month;
	}

	// This method is responsible to access the ano's value
	public int getYear()
	{
		return year;
	}

	// This method is responsible to modify the ano's value
	public void setYear(int year)
	{
		this.year = year;
	}

}
