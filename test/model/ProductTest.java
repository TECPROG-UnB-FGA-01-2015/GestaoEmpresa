package model;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductTest extends TestCase
{
	Product product;
	ArrayList<Product> productList;
	
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
	public void testProductCode()
	{
		product = new Product("1", "Mesas", 900, 5, 1000);
		product.setCode("2");
						
		assertSame("2", product.getCode());
	}
	
	@Test
	public void testProductDescription()
	{
		product = new Product("1", "Mesas", 900, 5, 1000);
		product.setDescription("Cadeiras");
						
		assertSame("Cadeiras", product.getDescription());
	}
	
	@Test
	public void testProductPurchasePrice()
	{
		product = new Product("1", "Mesas", 900, 5, 1000);
		product.setPurchasePrice(1200.0);
						
		assertEquals(1200.0, product.getPurchasePrice());
	}
	
	@Test
	public void testProductQuantity()
	{
		product = new Product("1", "Mesas", 900, 5, 1000);
		product.setQuantity(20.0);
						
		assertEquals(20.0, product.getQuantity());
	}
	
	@Test
	public void testProductSellingPrice()
	{
		product = new Product("1", "Mesas", 900, 5, 1000);
		product.setSellingPrice(1400.0);
						
		assertEquals(1400.0, product.getSellingPrice());
	}
}