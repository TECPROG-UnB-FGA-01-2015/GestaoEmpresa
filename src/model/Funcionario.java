
package model;


public class Funcionario {
    private String nome;
    private String telefone;
    private String celular;
    private String cpf;
    private String rg;
    private String cargo;
    private double salario;
    private Endereco endereco;

    public Funcionario(String nome, String telefone, String celular, String cpf, String rg, String cargo, double salario, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.cpf = cpf;
        this.rg = rg;
        this.cargo = cargo;
        this.salario = salario;
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
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

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
