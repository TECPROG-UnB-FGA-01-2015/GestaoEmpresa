/**********************************************************
 * File: PhysicalSupplier.java
 * Purpose: Holds all the attributes and methods of the
 * 		    subclass PhysicalSupplier.
 *********************************************************/

package model;

import java.util.ArrayList;

public class PhysicalSupplier extends Supplier
{
	private String cpf; // Describes the CPF of the Physical Supplier (only numbers; cpf >= 0; example : 62354823611)
	private String rg; // Describes the RG of the Physical Supplier (only numbers; rg >= 0;example: 3515236)

	/* Constructor to receive all the attributes as parameters and initialize the
	 * object PhysicalSupplier*/
	public PhysicalSupplier(String cpf,
							String rg,
							String name,
							String telephone,
							String cellphone,
							ArrayList<Product> productList,
							Address objectAddress)
	{
		super(name, telephone, cellphone, productList, objectAddress);
		this.cpf = cpf;
		this.rg = rg;
	}

	// Method to return the content of attribute cpf
	public String getCpf()
	{
		return cpf;
	}

	// Method to set a content on variable cpf
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	// Method to return the content of attribute rg
	public String getRg()
	{
		return rg;
	}

	// Method to set a content on variable rg
	public void setRg(String rg)
	{
		this.rg = rg;
	}
}