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

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getCellphone()
    {
        return cellphone;
    }

    public void setCellphone(String cellphone)
    {
        this.cellphone = cellphone;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}
