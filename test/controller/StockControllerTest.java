package controller;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StockControllerTest extends TestCase
{
	Product product;
	ArrayList<Product> productList;
	StockController stockController = new StockController(); 

	@Before
	public void setUp() throws Exception
	{
		product = new Product("1", "Mesas", 900, 5, 1000);
		productList = new ArrayList<Product>();
	}

	@After
	public void tearDown() throws Exception
	{
		productList.clear();
	}

	@Test
	public void testAddProduct()
	{
		stockController.addProduct(product);
		
		productList = stockController.getProductList();
		int listSize = productList.size();
		assertEquals(1,listSize);
	}
}