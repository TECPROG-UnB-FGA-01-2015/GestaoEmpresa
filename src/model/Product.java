/**********************************************************
 * File: Product.java
 * Purpose: Hold all the attributes and methods of Product
 **********************************************************/

package model;

public class Product
{
    private String code; // Describes the code of the product (code >= 0; example: 100123)
    private String description; // Describes the description of the product
    private double purchasePrice; // Describes the purchase price of the product (purchasePrice >= 0; example: 49,90)
    private double sellingPrice; // Describes the selling price of the product (sellingPrice >= 0; example: 99,90)
    private double quantity; // Describes the quantity of the product (quantity >= 0; example: 2,50)

    // Constructor to receive all the attributes as parameters and initialize the object Product
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

    // Access and returns the property code
    public String getCode()
    {
        return code;
    }

    // Sets a new value for the code property
    public void setCode(String code)
    {
        this.code = code;
    }

    // Access and returns the property description
    public String getDescription()
    {
        return description;
    }

    // Sets a new value for the description property
    public void setDescription(String description)
    {
        this.description = description;
    }

    // Access and returns the property purchasePrice
    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    // Sets a new value for the purchasePrice property
    public void setPurchasePrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    // Access and returns the property quantity
    public double getQuantity()
    {
        return quantity;
    }

    // Sets a new value for the quantity property
    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    // Access and returns the property sellingPrice
    public double getSellingPrice()
    {
        return sellingPrice;
    }

    // Sets a new value for the sellingPrice property
    public void setSellingPrice(double sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    } 
}
