/**********************************************************
 * File: Cliente.java
 * Purpose: Holds all the attributes and methods of the
 * 		    superclass Cliente.
 *********************************************************/		

package model;

public class Cliente
{
    protected String name; 
    protected Endereco address;
    protected String telephone;
    protected String cellphone;

    // Constructor of the Client's class
    public Cliente(String name, 
    		       Endereco address, 
    		       String telephone, 
    		       String cellphone)
    {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.cellphone = cellphone;
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

    // Access and returns the property address
    public Endereco getAddress()
    {
        return address;
    }

    // Sets a new value for the address property
    public void setAddress(Endereco address)
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
}
