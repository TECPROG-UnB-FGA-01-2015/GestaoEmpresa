/**********************************************************
 * File: JuridicalSupplier.java
 * Purpose: Holds all the attributes and methods of the
 * 		    subclass JuridicalSupplier.
 *********************************************************/

package model;

import java.util.ArrayList;

public class JuridicalSupplier extends Supplier
{
	private String socialReason; // Holds the info of the legal supplier's corporate name
	private String cnpj; // Holds the info of the legal supplier's cnpj

	/* Constructor to receive all the attributes as parameters and initialize the
	 * object JuridicalSupplier*/
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

	// Method to return the content of attribute socialReason
	public String getSocialReason()
	{
		return socialReason;
	}

	// Method to set a content on variable socialReason
	public void setSocialReason(String socialReason)
	{
		this.socialReason = socialReason;
	}

	// Method to return the content of attribute cnpj
	public String getCnpj()
	{
		return cnpj;
	}

	// Method to set a content on variable cnpj
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

}
