package model;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Expense;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExpenseTest extends TestCase
{
	Expense expense;
	ArrayList<Expense> expenseList;
	
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
	public void testExpenseName()
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expense.setName("Foi necessária a compra de 250 mesas.");
						
		assertSame("Foi necessária a compra de 250 mesas.", expense.getName());
	}
	
	@Test
	public void testExpenseDescription()
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expense.setDescription("Todas as 250 mesas são de boa qualidade!");
						
		assertSame("Todas as 250 mesas são de boa qualidade!", expense.getDescription());
	}
	
	@Test
	public void testExpenseValue()
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expense.setValue(1500.0);
						
		assertEquals(1500.0, expense.getValue());
	}
	
	@Test
	public void testExpenseDay()
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expense.setDay(20);
						
		assertEquals(20, expense.getDay());
	}
	
	@Test
	public void testExpenseMonth()
	{
		expense = new Expense("Foi necessária a compra extra de 50 cadeiras", "Todas as 50 cadeiras são de boa qualidade!", 1000, 15, 6, 2015);
		expense.setMonth(9);
						
		assertEquals(9, expense.getMonth());
	}
}