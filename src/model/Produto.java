/**********************************************************
 * File: Produto.java
 * Purpose: Hold all the attributes and methods of Produto
 **********************************************************/
package model;

public class Produto
{
    private String codigo;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private double quantidade;

    /* Constructor to receive all the attributes as parameters and initialize the
     * object Produto*/
    public Produto(String codigo,
    				String descricao,
    				double precoCompra,
    				double quantidade,
    				double precoVenda)
    {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    // Java default constructor
    public Produto()
    {
        // Nothing to do
    }

    // Method to return the content of attribute codigo
    public String getCodigo()
    {
        return codigo;
    }

    // Method to set a content on variable codigo
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    // Method to return the content of attribute descricao
    public String getDescricao()
    {
        return descricao;
    }

 // Method to set a content on variable descricao
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    // Method to return the content of attribute precoCompra
    public double getPrecoCompra()
    {
        return precoCompra;
    }

    // Method to set a content on variable precoCompra
    public void setPreco(double precoCompra)
    {
        this.precoCompra = precoCompra;
    }

    // Method to return the content of attribute quantidade
    public double getQuantidade()
    {
        return quantidade;
    }

 // Method to set a content on variable quantidade
    public void setQuantidade(double quantidade)
    {
        this.quantidade = quantidade;
    }

    // Method to return the content of attribute precoVenda
    public double getPrecoVenda()
    {
        return precoVenda;
    }

    // Method to set a content on variable precoVenda
    public void setPrecoVenda(double precoVenda)
    {
        this.precoVenda = precoVenda;
    }
    
}
