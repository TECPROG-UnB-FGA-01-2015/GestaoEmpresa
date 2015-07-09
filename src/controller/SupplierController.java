/**********************************************************
 * File: SupplierController.java
 * Purpose: Contains the Suppliers maintenance methods.
**********************************************************/

package controller;

import java.util.ArrayList;

import model.Supplier;
	
public class SupplierController
{
	private static ArrayList<Supplier> supplierList; // Describes a list of suppliers
	
	static {
		supplierList = new ArrayList<Supplier>();
	}

	// Constructor to initialize the controller of suppliers with a supplier list
	public SupplierController()
	{
		// Just initialize the object
	}

    // Access and returns the property supplierList
	public ArrayList<Supplier> getSupplierList()
	{
		return supplierList;
	}

    // Sets a new value for the supplierList property
	public static void setSupplierList(ArrayList<Supplier> supplierList)
	{
		SupplierController.supplierList = supplierList;
	}

	// Adds a supplier to the supplierList
	public void addSupplier(Supplier supplier)
	{
		supplierList.add(supplier);
	}

	// Removes a supplier of the supplierList
	public void removeSupplier(Supplier supplier)
	{
		supplierList.remove(supplier);
	}

	/* Parameter name:
	 * receives the info of name of the Supplier class's object 
	 * Parameter search:
	 * receives the boolean info of search
	 */
	
	// Search for a supplier in the supplierList with a given name
	public Supplier searchSupplier(String name, boolean search)
	{
		// Returns the supplier matching the given name (not Case Sensitive)
		Supplier supplierReturned = null;
		
		// Returns the suppler matching the given name (Case Sensitive)
		boolean exactReturned = false;
		
		// Search for the supplier
		for(Supplier supplier : supplierList)
		{
			// Describes the name of the supplier
			String nameSupplier = supplier.getName();
			
			// Describes result of supplier name comparison
			boolean nameSupplierEquals = nameSupplier.equalsIgnoreCase(name);
			
			// Converts the name of the supplier to lowercase
			String nameSupplierLowerCase = nameSupplier.toLowerCase();
			
			if(nameSupplierEquals == true)
			{
				supplierReturned = supplier;
				exactReturned = true;
				
			}
			else if(nameSupplierLowerCase.contains(name.toLowerCase()) && search == true)
			{
				if(exactReturned != true)
				{
					supplierReturned = supplier;
				}
				else
				{
					// Nothing to Do
				}	
				
			}
			else
			{
				// Nothing to Do
			}
		}
		
		return supplierReturned;

	}
}
