/**********************************************************
 * File: Client.java
 * Purpose: Holds all the attributes and methods of the
 * 		    superclass Client.
 *********************************************************/		

package model;

public class Client
{
    protected String name; // Describes the name of the client   
    protected Address address; // Describes the address of the client
    protected String telephone; // Describes the telephone of the client (example: 6132765432) 
    protected String cellphone; // Describes the cellphone of the client (example: 6198765432)

    // Constructor of the Client's class
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
}
