/**********************************************************
 * File: Product.java
 * Purpose: Hold all the attributes and methods of Product
 **********************************************************/
package model;

public class Product
{
    private String code;
    private String description;
    private double purchasePrice;
    private double sellingPrice;
    private double quantity;

    /* Constructor to receive all the attributes as parameters and initialize the
     * object Product*/
    public Product(String code,
    			   String description,
    			   double purchasePrice,
    			   double quantity,
    			   double sellingPrice)
    {
        this.code = code;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
    }

    // Java default constructor
    public Product()
    {
        // Nothing to do
    }

    // Method to return the content of attribute code
    public String getCode()
    {
        return code;
    }

    // Method to set a content on variable code
    public void setCode(String code)
    {
        this.code = code;
    }

    // Method to return the content of attribute description
    public String getDescription()
    {
        return description;
    }

 // Method to set a content on variable description
    public void setDescription(String description)
    {
        this.description = description;
    }

    // Method to return the content of attribute purchasePrice
    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    // Method to set a content on variable purchasePrice
    public void setPurchasePrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    // Method to return the content of attribute quantity
    public double getQuantity()
    {
        return quantity;
    }

 // Method to set a content on variable quantity
    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    // Method to return the content of attribute sellingPrice
    public double getSellingPrice()
    {
        return sellingPrice;
    }

    // Method to set a content on variable sellingPrice
    public void setSellingPrice(double sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    }
    
}
