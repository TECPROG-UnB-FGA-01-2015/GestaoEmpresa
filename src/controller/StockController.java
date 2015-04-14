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
    StockView stockView;
    private ArrayList<Product> productList;
    
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
    
    // Method to insert an element which is a Product type
    public void addProduct(Product product)
    {
        productList.add(product);
    }
   
    // Method to remove an element which is a Product type
    public void removeProduct(Product product)
    {
        productList.remove(product);
    }
    
    /* Method to search an element which is a Product type by passing as a parameter
     * a name
     */
    public Product searchProduct(String name, boolean search)
    {
        int i=0;
        Product returned = null;
        Product exactReturned = null;
        
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