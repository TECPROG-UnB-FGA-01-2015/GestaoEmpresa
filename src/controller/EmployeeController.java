/**********************************************************
 * File: ControleEmployee.java
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
            if((employee.getName().equalsIgnoreCase(name)))
            {
                exactReturned = employee;
            }
            else if((employee.getName().toLowerCase().contains(name.toLowerCase())) && ignoreCase == true)
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
