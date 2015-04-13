/**********************************************************
 * File: Supplier.java
 * Purpose: Holds all the attributes and methods of the
 * 		    superclass Supplier.
 *********************************************************/

package model;

import java.util.ArrayList;

public class Supplier
{
	protected String name;
	protected String telephone;
	protected String cellphone;
	protected ArrayList<Product> productList;
	protected Address address;
	
	
	/* Constructor to receive all the attributes as parameters and initialize the
	 * object Supplier*/
	public Supplier(String name,
					  String telephone,
					  String cellphone,
					  ArrayList<Product> productList,
					  Address address)
	{
		this.name = name;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.productList = productList;
		this.address = address;
	}
	
	// Method to return the content of attribute telephone
	public String getTelephone()
	{
		return telephone;
	}
	
	// Method to set a content on variable telephone
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	// Method to return the content of attribute cellphone
	public String getCellphone()
	{
		return cellphone;
	}

	// Method to set a content on variable cellphone
	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}

	// Method to return the content of attribute name
	public String getName()
	{
		return name;
	}

	// Method to set a content on variable name
	public void setName(String name)
	{
		this.name = name;
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

	// Method to return the content of attribute address
	public Address getAddress()
	{
		return address;
	}

	// Method to set a content on variable address
	public void setAddress(Address address)
	{
		this.address = address;
	}

}
