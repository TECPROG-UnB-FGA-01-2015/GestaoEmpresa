
package model;


public class ClienteFisico extends Cliente {
    
    private String cpf;
    private String rg;

    public ClienteFisico(String cpf, String rg, String nome, Endereco endereco, String telefone, String celular) {
        super(nome, endereco, telefone, celular);
        this.cpf = cpf;
        this.rg = rg;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    
    
}
