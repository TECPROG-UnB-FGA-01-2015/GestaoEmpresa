package model;

public class PhysicalClient extends Client
{
    private String cpf;
    private String rg;

    public PhysicalClient(String cpf, 
    			  String rg, 
    			  String nome, 
    			  Address address, 
    			  String telephone, 
    			  String cellphone)
    {
        super(nome, endereco, telephone, cellphone);
        this.cpf = cpf;
        this.rg = rg;
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
}
