
package model;

import java.util.ArrayList;


public class Fornecedor {
    protected String nome;
    protected String telefone;
    protected String celular;
    protected ArrayList<Produto> listaProduto;
    protected Endereco endereco;

    public Fornecedor(String nome, String telefone, String celular, ArrayList<Produto> listaProduto, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.listaProduto = listaProduto;
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
