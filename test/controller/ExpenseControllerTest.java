package controller;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Expense;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExpenseControllerTest extends TestCase
{
	Expense expense;
	ArrayList<Expense> expenselist;
	ExpenseController expenseController = new ExpenseController(); 

	@Before
	public void setUp() throws Exception
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expenselist = new ArrayList<Expense>();
	}

	@After
	public void tearDown() throws Exception
	{
		expenselist.clear();
	}
	
	@Test
	public void testAddExpense()
	{
		expenseController.addExpense(expense);
		
		expenselist = expenseController.getExpenseList();
		int listSize = expenselist.size();
		assertEquals(1,listSize);
	}
}