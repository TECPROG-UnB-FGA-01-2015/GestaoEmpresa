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

	private static ArrayList<Supplier> supplierList; // maintains a list of objects of type Supplier
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

	/* Parameter name:
	 * receives the info of name of the Supplier class's object 
	 * Parameter search:
	 * receives the boolean info of search*/
	
	// Method to find a supplier from the parameter name
	public Supplier pesquisarFornecedor(String name, boolean search)
	{
		// Receives an object from the Fornecedor class if the name is equal to received name and the research equals true
		Supplier returned = null;
		
		// Receives a Object from the Fornecedor Class if the name is equal to received name
		Supplier exactReturned = null; 
		
		int i = 0;
		
		/* Parameter supplier:
		 * Object from the Supplier Class that receives supplier's info and updates the list */
		for(Supplier supplier : supplierList)
		{
			if((supplier.getName().equalsIgnoreCase(name)))
			{
				exactReturned = supplier;
				i++;
			}
			else if((supplier.getName().toLowerCase().contains(name.toLowerCase())) && search == true)
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
