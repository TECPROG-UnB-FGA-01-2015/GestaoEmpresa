package controller;

import java.util.ArrayList;

import model.Transaction;
import model.Sale;
import model.Purchase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TransactionControllerTest extends TestCase
{
	Sale sale;
	Purchase purchase;
	ArrayList<Transaction> transactionList;
	TransactionController transactionController = new TransactionController();
	
	
	@Before
	protected void setUp() throws Exception
	{
		Sale sale = new Sale(null, null, 0, null, 0, 0, 0);
		Purchase purchase = new Purchase(null, null, 0, null, 0, 0, 0);
		transactionList = new ArrayList<Transaction>();
	}

	@After
	protected void tearDown() throws Exception
	{
		transactionList.clear();
	}

	@Test
	public void testAddTransaction()
	{
		transactionController.addTransaction(sale);
		
		transactionList = transactionController.getTransactionList();
		int listSize = transactionList.size();
		assertEquals(1,listSize);
	}

	@Test
	public void testRemoveTransaction()
	{
		transactionController.addTransaction(purchase);
		
		transactionList = transactionController.getTransactionList();
		transactionController.removeTransaction(purchase);
		
		int listSize = transactionList.size();
		assertEquals(0,listSize);
	}

}
