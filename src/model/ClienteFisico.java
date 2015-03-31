package model;

public class PhysicalClient extends Client
{
    private String cpf;
    private String rg;

    // Constructor of the PhysicalClient's class
    public PhysicalClient(String cpf, 
    			  String rg, 
    			  String nome, 
    			  Address address, 
    			  String telephone, 
    			  String cellphone)
    {
        super(nome, address, telephone, cellphone);
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
