/**********************************************************
 * File: EmployeeController.java
 * Purpose: Contains the Employees maintenance methods
**********************************************************/		

package controller;

import java.util.ArrayList;
import model.Employee;

public class EmployeeController 
{
    private static ArrayList<Employee> employeeList; // Holds all the employees registered on the system

    // Constructor of the EmployeeController's class
    public EmployeeController() 
    {
        employeeList = new ArrayList<Employee>();
    }

    // Access and returns the property employeeList
    public ArrayList<Employee> getEmployeeList() 
    {
        return employeeList;
    }

    // Sets a new value for the employeeList property
    public void setEmployeeList(ArrayList<Employee> employeeList) 
    {
        this.employeeList = employeeList;
    }
    
    // Adds an employee to the employeeList 
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    
    // Removes an employee of the employeeList
    public void removeEmployee(Employee employee)
    {
        employeeList.remove(employee);
    }

    // Search for an employee in the clientList with a given name
    public Employee searchEmployee(String name, boolean ignoreCase)
    {
    	Employee returned = null; // Used to return the employee matching the given name (not Case Sensitive)
    	Employee exactReturned = null; // Used to return the employee matching the given name (Case Sensitive)
    	
        // Search for the employee 
        for(Employee employee: employeeList)
        {
        	
        	// Variable to get the name of current employee
        	String employeeName = employee.getName();
        	
        	// Variable to return the comparison of current employee name with the name parameter  
        	boolean employeeNameEquals = employeeName.equalsIgnoreCase(name);
        	
        	// Variable to pass the employee name to lowercase
        	String employeeNameToLowerCase = employeeName.toLowerCase();
        	
            if(employeeNameEquals == true)
            {
                exactReturned = employee;
            }
            else if((employeeNameToLowerCase.contains(name.toLowerCase())) && ignoreCase == true)
            {
                returned = employee;
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
