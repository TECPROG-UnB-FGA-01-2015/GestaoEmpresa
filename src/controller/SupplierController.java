/**********************************************************
 * File: SupplierController.java
 * Purpose: Contains the Suppliers maintenance methods.
**********************************************************/

package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Supplier;
import view.ContactView;
	
public class SupplierController
{
	private static ArrayList<Supplier> supplierList; // maintains a list of objects of type Supplier
	ContactView contactView;

	// Constructor to instance SupplierController with the attribute supplierList
	public SupplierController()
	{
		SupplierController.supplierList = new ArrayList<Supplier>();
	}

	// Method to return the content of attribute supplierList
	public ArrayList<Supplier> getSupplierList()
	{
		return supplierList;
	}

	// Method to set a content on variable listaForncedor
	public void setSupplierList(ArrayList<Supplier> supplierList)
	{
		SupplierController.supplierList = supplierList;
	}

	// Method to insert a supplier to attribute supplierList
	public void addSupplier(Supplier supplier)
	{
		supplierList.add(supplier);
	}

	// Method for removing an attribute provider supplierList
	public void removeSupplier(Supplier supplier)
	{
		supplierList.remove(supplier);
	}

	/* Parameter name:
	 * receives the info of name of the Supplier class's object 
	 * Parameter search:
	 * receives the boolean info of search*/
	
	// Method to find a supplier from the parameter name
	public Supplier searchSupplier(String name, boolean search)
	{
		// Receives an object from the Fornecedor class if the name is equal to received name and the research equals true
		Supplier returned = null;
		
		// Receives a Object from the Fornecedor Class if the name is equal to received name
		Supplier exactReturned = null; 
		
		/* Parameter supplier:
		 * Object from the Supplier Class that receives supplier's info and updates the list */
		for(Supplier supplier : supplierList)
		{
			// Name of the supplier
			String nameSupplier = supplier.getName();
			
			// Result of supplier name comparison
			boolean nameSupplierEquals = nameSupplier.equalsIgnoreCase(name);
			
			// Changing the name of the supplier to lower case
			String nameSupplierLowerCase = nameSupplier.toLowerCase();
			
			if(nameSupplierEquals == true)
			{
				exactReturned = supplier;
			}
			else if(nameSupplierLowerCase.contains(name.toLowerCase()) && search == true)
			{
				returned = supplier;
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
