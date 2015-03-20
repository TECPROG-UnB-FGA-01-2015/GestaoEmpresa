
package model;

import java.util.ArrayList;

public class FornecedorJuridico extends Fornecedor{
    private String razaoSocial;
    private String cnpj;

    public FornecedorJuridico(String razaoSocial, String cnpj, String nome, String telefone, String celular, ArrayList<Produto> listaProduto, Endereco umEndereco) {
        super(nome, telefone, celular, listaProduto, umEndereco);
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
