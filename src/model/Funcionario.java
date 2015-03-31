package model;

public class Employee
{
    private String name;
    private String telephone;
    private String cellphone;
    private String cpf;
    private String rg;
    private String role;
    private double salary;
    private Address address;

    // Constructor of the Employee's class
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
