package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Employee;
import view.ContactView;

public class EmployeeController 
{
    private static ArrayList<Employee> employeeList;
    TelaContatos telaContatos;

    public EmployeeController() 
    {
        employeeList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList() 
    {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) 
    {
        this.employeeList = employeeList;
    }
    
    public void adicionarEmployee(Employee f)
    {
        employeeList.add(f);
    }
    public void removerEmployee(Employee f)
    {
        employeeList.remove(f);
    }
    
    public Employee pesquisarEmployee(String nome, boolean pesquisa)
    {
        Employee volta = null;
        Employee voltaExata = null;
        int i=0;
        for(Employee f: employeeList)
        {
            if((f.getNome().equalsIgnoreCase(nome)))
            {
                voltaExata = f;
                i = i + 1;
            }
            else if((f.getNome().toLowerCase().contains(nome.toLowerCase())) && pesquisa == true)
            {
                volta = f;
                i = i + 1;
            }
        }

        if(voltaExata!=null)
        {
            return voltaExata;
        }
        else if(volta!=null)
        {
            return volta;
        }
        return null;
    }
}
