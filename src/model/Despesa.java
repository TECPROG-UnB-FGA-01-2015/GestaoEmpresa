/**********************************************************
 * File: Despesa.java
 * Purpose: Hold all the attributes and methods of Despesa
**********************************************************/		
package model;

public class Despesa
{
    protected String nome;
    protected String descricao;
    protected double valor;
    protected int dia;
    protected int mes;
    protected int ano;
    
    /* Constructor to receive all the attributes as parameters and initialize the
     * object Despesa*/
    public Despesa(String nome,
    				String descricao,
    				double valor,
    				int dia,
    				int mes,
    				int ano)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Method to return the content of attribute nome
    public String getNome()
    {
        return nome;
    }

    // Method to set a content on variable nome
    public void setNome(String nome)
    {
        this.nome = nome;
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

    // Method to return the content of attribute valor
    public double getValor()
    {
        return valor;
    }

    // Method to set a content on variable valor
    public void setValor(double valor)
    {
        this.valor = valor;
    }

    // Method to return the content of attribute mes
    public int getMes()
    {
        return mes;
    }

    // Method to set a content on variable mes
    public void setMes(int mes)
    {
        this.mes = mes;
    }

    // Method to return the content of attribute ano
    public int getAno()
    {
        return ano;
    }

    // Method to set a content on variable ano
    public void setAno(int ano)
    {
        this.ano = ano;
    }

    // Method to return the content of attribute dia
    public int getDia()
    {
        return dia;
    }

    // Method to set a content on variable dia
    public void setDia(int dia)
    {
        this.dia = dia;
    }
    
}
