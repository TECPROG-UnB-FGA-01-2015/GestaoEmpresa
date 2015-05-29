/**********************************************************
 * File: PhysicalClient.java
 * Purpose: Holds all the attributes and methods of the
 * 		    subclass PhysicalClient.
 *********************************************************/		

package model;

public class PhysicalClient extends Client
{
    private String cpf; // Describes the CPF of the Physical Client (only numbers; cpf >= 0; example : 62354823611)
    private String rg; // Describes the RG of the Physical Client (only numbers; rg >= 0; example: 3515236)

    // Constructor to receive all the attributes as parameters and initialize the object PhysicalClient
    public PhysicalClient(String cpf, 
    			  		  String rg, 
    			  		  String name, 
    			  		  Address address, 
    			  		  String telephone, 
    			  		  String cellphone)
    {
        super(name, address, telephone, cellphone);
        this.cpf = cpf;
        this.rg = rg;
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

    // Access and returns the property rg
    public String getRg()
    {
        return rg;
    }

    // Sets a new value for the rg property
    public void setRg(String rg)
    {
        this.rg = rg;
    } 
}
