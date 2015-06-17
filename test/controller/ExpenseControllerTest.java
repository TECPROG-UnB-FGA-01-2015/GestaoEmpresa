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
	ArrayList<Expense> expenseList;
	ExpenseController expenseController = new ExpenseController(); 

	@Before
	public void setUp() throws Exception
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expenseList = new ArrayList<Expense>();
	}

	@After
	public void tearDown() throws Exception
	{
		expenseList.clear();
	}
	
	@Test
	public void testAddExpense()
	{
		expenseController.addExpense(expense);
		
		expenseList = expenseController.getExpenseList();
		int listSize = expenseList.size();
		assertEquals(1,listSize);
	}
	
	@Test
	public void testRemoveExpense()
	{
		expenseController.addExpense(expense);
		
		expenseList = expenseController.getExpenseList();
		expenseController.removeExpense(expense);
		int listSize = expenseList.size();
		assertEquals(0,listSize);
	}
	
	@Test
	public void testExpenseNotNull()
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		assertNotNull(expense);
	}
}