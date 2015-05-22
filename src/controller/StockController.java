/**********************************************************
 * File: StockController.java
 * Purpose: Contains the Products' maintenance methods
 **********************************************************/

package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import view.StockView;

public class StockController
{
	StockView stockView; // Calls StockView view
	private ArrayList<Product> productList; // Maintains a list of Product object

	// Constructor to instance ControleEstoque with the attribute productList
	public StockController()
	{
		this.productList = new ArrayList<Product>();
	}

	// Method to return the content of attribute productList
	public ArrayList<Product> getProductList()
	{
		return productList;
	}

	// Method to set a content on variable productList
	public void setProductList(ArrayList<Product> productList)
	{
		this.productList = productList;
	}

	// Adds a product to the productList
	public void addProduct(Product product)
	{
		productList.add(product);
	}

	// Removes a product of the productList
	public void removeProduct(Product product)
	{
		productList.remove(product);
	}

	// Search for a product in the productList with a given name
	public Product searchProduct(String code, boolean searchContains)
	{
		int productCounter = 0;
		Product returned = null; // Used to return the product matching the given name (not Case Sensitive)
		Product exactReturned = null; // Used to return the product matching the given name (Case Sensitive)

		// Search for the employee
		for (Product product : productList)
		{
			String productCode = product.getCode();
			boolean productCodeEquals = productCode.equalsIgnoreCase(code);

			if (productCodeEquals == true)
			{
				productCounter++;
				exactReturned = product;
			}
			else
			{
				// Nothing to do
			}

			String productCodeToLowerCase = productCode.toLowerCase();
			boolean productCodeContains = productCodeToLowerCase.contains(code.toLowerCase()); 
			
			if (productCodeContains && searchContains == true)
			{
				productCounter++;
				returned = product;
			}
			else
			{
				// Nothing to do
			}

			String productDescription = product.getDescription();
			boolean productDescriptionContains = productDescription.toLowerCase().contains(code.toLowerCase());

			if (productDescriptionContains && searchContains == true)
			{
				returned = product;
				productCounter++;
			}
			else
			{
				// Nothing to do
			}

			boolean productDescriptionEquals = productDescription.equalsIgnoreCase(code);
			
			if (productDescriptionEquals)
			{
				exactReturned = product;
			}
			else
			{
				// Nothing to do
			}
		}

		if (productCounter > 1 && searchContains == true)
		{
			JOptionPane.showMessageDialog(stockView, "Mais de um resultado"
			        + "encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			// Nothing to do
		}

		if (exactReturned != null)
		{
			return exactReturned;
		}

		else if (returned != null)
		{
			return returned;
		}
		else
		{
			return null;
		}
	}
}
