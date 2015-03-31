package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Employee;
import view.ContactView;

public class EmployeeController 
{
    private static ArrayList<Employee> employeeList;
    ContactView contactView;

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
    public Employee searchEmployee(String nome, boolean pesquisa)
    {
        Employee returned = null;
        Employee exactReturned = null;
        int i=0;
        for(Employee employee: employeeList)
        {
            if((f.getNome().equalsIgnoreCase(nome)))
            {
                exactReturned = employee;
                i = i + 1;
            }
            else if((employee.getNome().toLowerCase().contains(nome.toLowerCase())) && pesquisa == true)
            {
                returned = employee;
                i = i + 1;
            }
        }

        if(exactReturned!=null)
        {
            return exactReturned;
        }
        else if(returned!=null)
        {
            return returned;
        }
        return null;
    }
}
