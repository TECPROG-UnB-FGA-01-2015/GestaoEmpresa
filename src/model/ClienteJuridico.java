package model;

public class JuridicalClient extends Client
{
    private String socialReason;
    private String cnpj;

    public JuridicalClient(String socialReason,
                           String cnpj,
                           String nome,
                           Address address,
                           String telephone,
                           String cellphone)
    {
        super(name, address, telephone, cellphone);
        this.socialReason = socialReason;
        this.cnpj = cnpj;
    }

    public String getSocialReason()
    {
        return socialReason;
    }

    public void setSocialReason(String socialReason)
    {
        this.socialReason = socialReason;
    }

    public String getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }
}
