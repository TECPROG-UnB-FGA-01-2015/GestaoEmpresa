/**********************************************************
 * File: ControleFuncionario.java
 * Purpose: Contains the Employees maintenance methods
**********************************************************/		

package controller;

import java.util.ArrayList;
import model.Employee;
import view.TelaContatos;

public class EmployeeController 
{
    private static ArrayList<Employee> employeeList;
    TelaContatos telaContatos;

    // Constructor of the EmployeeController's class
    public EmployeeController() 
    {
        employeeList = new ArrayList<Employee>();
    }

    // Access and returns the property employeeList
    public ArrayList<Employee> getListaFuncionario() 
    {
        return employeeList;
    }

    // Sets a new value for the employeeList property
    public void setListaFuncionario(ArrayList<Employee> employeeList) 
    {
        this.employeeList = employeeList;
    }
    
    // Adds an employee to the employeeList 
    public void addFuncionario(Employee funcionario)
    {
        employeeList.add(funcionario);
    }
    
    // Removes an employee of the employeeList
    public void removerFuncionario(Employee funcionario)
    {
        employeeList.remove(funcionario);
    }

    // Search for an employee in the clientList with a given name
    public Employee searchFuncionario(String nome, boolean pesquisa)
    {
    	Employee returned = null;
    	Employee exactReturned = null;
        int i=0;
        for(Employee employee: employeeList)
        {
            if((employee.getName().equalsIgnoreCase(nome)))
            {
                exactReturned = employee;
                i = i + 1;
            }
            else if((employee.getName().toLowerCase().contains(nome.toLowerCase())) && pesquisa == true)
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
