/**********************************************************
 * File: ExpenseController.java
 * Purpose: Contains the Expense maintenance methods
 **********************************************************/

package controller;

import java.util.ArrayList;
import model.Expense;

public class ExpenseController
{
	private ArrayList<Expense> expenseList; // Describes a list of spent of Expense object

	// Constructor to initialize the controller of expenses with an expense list
	public ExpenseController()
	{
		this.expenseList = new ArrayList<Expense>();
	}

    // Access and returns the property expenseList
	public ArrayList<Expense> getExpenseList()
	{
		return expenseList;
	}

    // Sets a new value for the expenseList property
	public void setExpenseList(ArrayList<Expense> expenseList)
	{
		this.expenseList = expenseList;
	}

    // Adds an expense to the expenseList 
	public void addExpense(Expense objectExpense)
	{
		expenseList.add(objectExpense);
	}

    // Removes an expense of the expenseList
	public void removeExpense(Expense objectExpense)
	{
		expenseList.remove(objectExpense);
	}

    // Search for an expense in the expenseList with a given name
	public Expense searchExpense(String name)
	{
		// Search for the expense
		for (Expense objectExpense : expenseList)
		{
			String objectExpenseName = objectExpense.getName();
			boolean objectExpenseNameEquals = objectExpenseName.equalsIgnoreCase(name);

			if (objectExpenseNameEquals == true)
			{
				return objectExpense;
			}
			else
			{
				// Nothing to do
			}
		}
		return null;
	}
}
