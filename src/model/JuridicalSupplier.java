/**********************************************************
 * File: JuridicalSupplier.java
 * Purpose: Holds all the attributes and methods of the
 * 		    subclass JuridicalSupplier.
 *********************************************************/

package model;

import java.util.ArrayList;

public class JuridicalSupplier extends Supplier
{
	private String socialReason; // Describes the social reason of the company
	private String cnpj; // Describes the CNPJ of the company (example: 21.163.235/0001-74)

	// Constructor to receive all the attributes as parameters and initialize the object JuridicalSupplier
	public JuridicalSupplier(String socialReason,
							 String cnpj,
							 String name,
							 String telephone,
							 String cellphone,
							 ArrayList<Product> productList,
							 Address objectAddress)
	{
		super(name, telephone, cellphone, productList, objectAddress);
		this.socialReason = socialReason;
		this.cnpj = cnpj;
	}

    // Access and returns the property socialReason
	public String getSocialReason()
	{
		return socialReason;
	}

    // Sets a new value for the socialReason property
	public void setSocialReason(String socialReason)
	{
		this.socialReason = socialReason;
	}

    // Access and returns the property cnpj
	public String getCnpj()
	{
		return cnpj;
	}

    // Sets a new value for the cnpj property
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}
}
