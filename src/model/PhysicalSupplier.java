/**********************************************************
 * File: PhysicalSupplier.java
 * Purpose: Holds all the attributes and methods of the
 * 		    subclass PhysicalSupplier.
 *********************************************************/

package model;

import java.util.ArrayList;

public class PhysicalSupplier extends Supplier
{
	private String cpf; // Holds the info of the  physical supplier's  cpf
	private String rg; // Holds the info of the  physical supplier's  rg

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

	// Access and returns the property cpf
	public String getCpf()
	{
		return cpf;
	}

	// Sets a new value for the cpf property
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	// Access and returns the property rg
	public String getRg()
	{
		return rg;
	}

	// Sets a new value for the rg property
	public void setRg(String rg)
	{
		this.rg = rg;
	}
}