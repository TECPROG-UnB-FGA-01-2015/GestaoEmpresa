/**********************************************************
 * File: SupplierController.java
 * Purpose: Contains the Suppliers maintenance methods.
**********************************************************/

package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Supplier;
import view.TelaContatos;
	
public class SupplierController
{

	private static ArrayList<Supplier> supplierList;
	TelaContatos telaContatos;

	// Constructor to instance SupplierController with the attribute supplierList
	public SupplierController()
	{
		this.supplierList = new ArrayList<Supplier>();
	}

	// Method to return the content of attribute supplierList
	public ArrayList<Supplier> getSupplierList()
	{
		return supplierList;
	}

	// Method to set a content on variable listaForncedor
	public void setSupplierList(ArrayList<Supplier> supplierList)
	{
		this.supplierList = supplierList;
	}

	// Method to insert a supplier to attribute supplierList
	public void adicionarFornecedor(Supplier supplier)
	{
		supplierList.add(supplier);
	}

	// Method for removing an attribute provider supplierList
	public void removerFornecedor(Supplier supplier)
	{
		supplierList.remove(supplier);
	}

	// Method to find a supplier from the parameter name
	public Supplier pesquisarFornecedor(String name, boolean search)
	{
		Supplier returned = null;
		Supplier exactReturned = null;
		int i = 0;
		for(Supplier supplier : supplierList)
		{
			if((supplier.getNome().equalsIgnoreCase(name)))
			{
				exactReturned = supplier;
				i++;
			}
			else if((supplier.getNome().toLowerCase().contains(name.toLowerCase())) && search == true)
			{
				returned = supplier;
				i++;
			}
			else
			{
				// Nothing to Do
			}
		}

		if(exactReturned != null)
		{
			return exactReturned;
		}
		else if(returned != null)
		{
			return returned;
		}
		else
		{
			return null;
		}
	}

}
