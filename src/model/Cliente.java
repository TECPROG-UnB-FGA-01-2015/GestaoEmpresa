package model;

public class Client
{
    protected String name;
    protected Address address;
    protected String telephone;
    protected String cellphone;

    public Client(String name, 
    		  Address address, 
    		  String telephone, 
    		  String cellphone)
    {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.cellphone = cellphone;
    }

    public String getname()
    {
        return name;
    }

    public void setname(String name)
    {
        this.name = name;
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
}
