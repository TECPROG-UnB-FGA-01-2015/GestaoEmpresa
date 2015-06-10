/**********************************************************
 * File: Supplier.java
 * Purpose: Holds all the attributes and methods of the
 * 		    superclass Supplier.
 *********************************************************/

package model;

import java.util.ArrayList;

public class Supplier
{
	protected String name; // Describes the name of the supplier
	protected String telephone; // Describes the telephone number of the supplier (only numbers; example: 6132765432)
	protected String cellphone; // Describes the cellphone mobile of the supplier (only numbers; example: 6132765432)
	protected Address address; // Describes the address of the supplier
	protected ArrayList<Product> productList; // Describes a list of products of the supplier
	
	
	// Constructor to receive all the attributes as parameters and initialize the object Supplier
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
	
	// Access and returns the property name
	public String getName()
	{
		return name;
	}

	// Sets a new value for the name property
	public void setName(String name)
	{
		this.name = name;
	}
	
	// Access and returns the property telephone
	public String getTelephone()
	{
		return telephone;
	}
	
	// Sets a new value for the telephone property
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	// Access and returns the property cellphone
	public String getCellphone()
	{
		return cellphone;
	}

	// Sets a new value for the cellphone property
	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}
	

	// Access and returns the property address
	public Address getAddress()
	{
		return address;
	}

	// Sets a new value for the address property
	public void setAddress(Address address)
	{
		this.address = address;
	}

	// Access and returns the productList
	public ArrayList<Product> getProductList()
	{
		return productList;
	}

	// Sets a new value for the productList
	public void setProductList(ArrayList<Product> productList)
	{
		this.productList = productList;
	}
}
