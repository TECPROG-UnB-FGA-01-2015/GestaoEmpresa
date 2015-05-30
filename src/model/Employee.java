/**********************************************************
 * File: Employee.java
 * Purpose: Holds all the attributes and methods of the
 * 		    class Employee.
 *********************************************************/	

package model;

public class Employee
{
    private String name; // Describes the name of the client
    private String telephone; // Describes the telephone of the client (only numbers; example: 6132765432) 
    private String cellphone; // Describes the telephone of the client (only numbers; example: 6198765432) 
    private String cpf; // Describes the cpf of the client (only numbers; example: 32432432411)
    private String rg; // Describes the rg of the client (only numbers; example: 3177732)
    private String role; // Describes the role of the client
    private double salary; // Describes the salary of the client (example: 542,50)
    private Address address; // Describes the address of the client

    // Constructor to receive all the attributes as parameters and initialize the object Employee
    public Employee(String name,
                    String telephone,
                    String cellphone,
                    String cpf,
                    String rg,
                    String role,
                    double salary,
                    Address address)
    {
        this.name = name;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.cpf = cpf;
        this.rg = rg;
        this.role = role;
        this.salary = salary;
        this.address = address;
    }

    // Access and returns the property address
    public Address getAddress()
    {
        return address;
    }

    // Sets a new value for the address property
    public void setAddress(Address address)
    {
        this.address = address;
    }

    // Access and returns the property telephone
    public String getTelephone()
    {
        return telephone;
    }

    // Sets a new value for the telephone property
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    // Access and returns the property cellphone
    public String getCellphone()
    {
        return cellphone;
    }

    // Sets a new value for the cellphone property
    public void setCellphone(String cellphone)
    {
        this.cellphone = cellphone;
    }

    // Access and returns the property cpf
    public String getCpf()
    {
        return cpf;
    }

    // Sets a new value for the cpf property
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    // Access and returns the property socialReason
    public String getRg()
    {
        return rg;
    }

    // Sets a new value for the rg property
    public void setRg(String rg)
    {
        this.rg = rg;
    }

    // Access and returns the property name
    public String getName()
    {
        return name;
    }

    // Sets a new value for the name property
    public void setName(String name)
    {
        this.name = name;
    }

    // Access and returns the property role
    public String getRole()
    {
        return role;
    }

    // Sets a new value for the role property
    public void setRole(String role)
    {
        this.role = role;
    }

    // Access and returns the property salary
    public double getSalary()
    {
        return salary;
    }

    // Sets a new value for the salary property
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}
