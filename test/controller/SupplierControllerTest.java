package controller;

import java.util.ArrayList;

import model.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

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
	public void testAddSupplier()
	{
		supplierController.addSupplier(supplier);

		supplierList = supplierController.getSupplierList();
		
		int listSize = supplierList.size();
		assertEquals(1, listSize);
	}
	
	@Test
	public void testRemoveSupplier()
	{
		supplierController.addSupplier(supplier);
		
		supplierList = supplierController.getSupplierList();
		
		supplierController.removeSupplier(supplier);
		
		int listSize = supplierList.size();
		assertEquals(0, listSize);
	}
}
