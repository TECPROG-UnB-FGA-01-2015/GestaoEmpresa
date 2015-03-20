package model;


public class Produto {
    
    private String codigo;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private double quantidade;

    public Produto(String codigo, String descricao, double precoCompra, double quantidade, double precoVenda) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public Produto() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPreco(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    
    
    
}
