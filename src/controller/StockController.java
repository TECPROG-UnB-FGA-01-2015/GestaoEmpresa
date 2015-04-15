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
    public Product searchProduct(String name, boolean search)
    {
        int i=0;
        Product returned = null; // Used to return the product matching the given name (not Case Sensitive)
        Product exactReturned = null; // Used to return the product matching the given name (Case Sensitive)
        
        // Search for the employee
        for(Product product:productList)
        {
            if(product.getCode().toLowerCase().contains(name.toLowerCase())&&search==
            		true)
            {
                i++;
                returned = product;
            }
            
            if(product.getCode().equalsIgnoreCase(name))
            {
                exactReturned = product;
            }
            
            if(product.getDescription().toLowerCase().contains(name.toLowerCase())&&search==
            		true)
            {
                returned = product;
                i++;
            }
            
            if(product.getDescription().equalsIgnoreCase(name))
            {
                exactReturned = product;
            }
            
        }
        
        if(i>1&&search==true)
        {
            JOptionPane.showMessageDialog(stockView, "Mais de um resultado"
            		+ "encontrado","Atenção" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(exactReturned != null)
        {
            return exactReturned;
        }
        
        else if(returned != null)
        {
            return returned;
        }
        
        return null;
        
    }
    
}