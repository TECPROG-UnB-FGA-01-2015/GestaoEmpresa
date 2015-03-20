package model;

public class ClienteJuridico extends Cliente {
    private String razaoSocial;
    private String cnpj;

    public ClienteJuridico(String razaoSocial, String cnpj, String nome, Endereco umEndereco, String telefone, String celular) {
        super(nome, umEndereco, telefone, celular);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    
}
