package model;

public class ClienteJuridico extends Cliente
{
    private String socialReason;
    private String cnpj;

    // Constructor of the JuridicalClient's class
    public ClienteJuridico(String socialReason,
                           String cnpj,
                           String name,
                           Endereco address,
                           String telephone,
                           String cellphone)
    {
        super(name, address, telephone, cellphone);
        this.socialReason = socialReason;
        this.cnpj = cnpj;
    }

    // Access and returns the property socialReason
    public String getSocialReason()
    {
        return socialReason;
    }

    // Sets a new value for the socialReason property
    public void setSocialReason(String socialReason)
    {
        this.socialReason = socialReason;
    }

    // Access and returns the property cnpj
    public String getCnpj()
    {
        return cnpj;
    }

    // Sets a new value for the cnpj property
    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }
}
