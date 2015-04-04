package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.TelaContatos;

public class ControleFuncionario 
{
    private static ArrayList<Funcionario> employeeList;
    TelaContatos telaContatos;

    // Constructor of the EmployeeController's class
    public ControleFuncionario() 
    {
        employeeList = new ArrayList<Funcionario>();
    }

    // Access and returns the property employeeList
    public ArrayList<Funcionario> getEmployeeList() 
    {
        return employeeList;
    }

    // Sets a new value for the employeeList property
    public void setEmployeeList(ArrayList<Funcionario> employeeList) 
    {
        this.employeeList = employeeList;
    }
    
    // Adds an employee to the employeeList 
    public void addEmployee(Funcionario funcionario)
    {
        employeeList.add(funcionario);
    }
    
    // Removes an employee of the employeeList
    public void removeEmployee(Funcionario funcionario)
    {
        employeeList.remove(funcionario);
    }

    // Search for an employee in the clientList with a given name
    public Funcionario searchEmployee(String nome, boolean pesquisa)
    {
    	Funcionario returned = null;
    	Funcionario exactReturned = null;
        int i=0;
        for(Funcionario funcionario: employeeList)
        {
            if((f.getNome().equalsIgnoreCase(nome)))
            {
                exactReturned = funcionario;
                i = i + 1;
            }
            else if((funcionario.getName().toLowerCase().contains(nome.toLowerCase())) && pesquisa == true)
            {
                returned = funcionario;
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
