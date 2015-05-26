/**********************************************************
 * File: ExpenseController.java
 * Purpose: Contains the Expense maintenance methods
 **********************************************************/

package controller;

import java.util.ArrayList;
import model.Expense;

public class ExpenseController
{
	private ArrayList<Expense> expenseList; // Maintains a list of spent of Expense object

	// Constructor to instance ControleDespesa with the attribute expenseList
	public ExpenseController()
	{
		this.expenseList = new ArrayList<Expense>();
	}

	// Method to return the content of attribute expenseList
	public ArrayList<Expense> getExpenseList()
	{
		return expenseList;
	}

	// Method to set a content on variable expenseList
	public void setExpenseList(ArrayList<Expense> expenseList)
	{
		this.expenseList = expenseList;
	}

	// Method to insert an element which is a Expense type
	public void addExpense(Expense objectExpense)
	{
		expenseList.add(objectExpense);
	}

	// Method to remove an element which is a Expense type
	public void removeExpense(Expense objectExpense)
	{
		expenseList.remove(objectExpense);
	}

	/* Method to search an element which is a Expense type by passing as a
	 * parameter a name */
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
