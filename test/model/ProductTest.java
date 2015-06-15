package model;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import junit.framework.TestCase;
import model.Product;
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
	
}