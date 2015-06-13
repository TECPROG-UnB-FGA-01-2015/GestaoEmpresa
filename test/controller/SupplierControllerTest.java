package controller;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SupplierControllerTest extends TestCase
{
	Supplier supplier;
	ArrayList<Supplier> supplierList;
	SupplierController supplierController = new SupplierController();

	@Before
	protected void setUp() throws Exception
	{
		Supplier supplier = new Supplier("", "", "", null, null);
		supplierList = new ArrayList<Supplier>();
	}

	@After
	protected void tearDown() throws Exception
	{
		supplierList.clear();
	}

	@Test
	protected void addSuppliertest()
	{
		supplierController.addSupplier(supplier);
		
		supplierList = supplierController.getSupplierList();
		
		int listSize = supplierList.size();
		assertEquals(1, listSize);
	}
	
	@Test
	public void removeSupplierTest()
	{
		supplierController.addSupplier(supplier);
		
		supplierList = supplierController.getSupplierList();
		supplierController.removeSupplier(supplier);
		
		int listSize = supplierList.size();
		assertEquals(0, listSize);
	}
}
