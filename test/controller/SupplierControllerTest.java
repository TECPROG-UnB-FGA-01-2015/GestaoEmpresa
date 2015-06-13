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
	protected void test()
	{

	}
}
