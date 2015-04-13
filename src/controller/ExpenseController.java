/**********************************************************
 * File: ControleDespesa.java
 * Purpose: Contains the Despesa maintenance methods
**********************************************************/
package controller;

import java.util.ArrayList;
import model.Expense;

public class ExpenseController
{
    private ArrayList<Expense> expenseList;

    // Constructor to instance ControleDespesa with the attribute expenseList 
    public ExpenseController()
    {
        this.expenseList = new ArrayList<Expense>();
    }

    // Method to return the content of attribute expenseList
    public ArrayList<Expense> getListaGasto()
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
    
    /* Method to search an element which is a Expense type by passing as a parameter a
     * name
     */
    public Expense searchExpense(String name)
    {
        for(Expense objectExpense: expenseList)
        {
            if(objectExpense.getName().equalsIgnoreCase(name))
            {
                return objectExpense;
            }
        }
        return null;
    }
   
}
