/***********************************************************
 * File: Transacao.java
 * Purpose: Gets the Transaction's info to sell Products.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Transacao
{
	protected ArrayList<Produto> listaVenda;
	protected double preco;
	protected Funcionario funcionario;
	protected int dia;
	protected int mes;
	protected int ano;

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Transacao's objects as self references */
	public Transacao(ArrayList<Produto> listaVenda,
	                 double preco,
	                 Funcionario funcionario,
	                 int dia,
	                 int mes,
	                 int ano)
	{
		this.listaVenda = listaVenda;
		this.preco = preco;
		this.funcionario = funcionario;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	// This method is responsible to access the listaVenda's protected value from the Produto's ArrayList
	public ArrayList<Produto> getListaVenda()
	{
		return listaVenda;
	}

	// This method is responsible to modify the listaVenda's protected value from the Produto's ArrayList
	public void setListaVenda(ArrayList<Produto> listaVenda)
	{
		this.listaVenda = listaVenda;
	}

	// This method is responsible to access the preco's value
	public double getPreco()
	{
		return preco;
	}

	// This method is responsible to modify the preco's value
	public void setPreco(double preco)
	{
		this.preco = preco;
	}

	// This method is responsible to access the funcionario's value
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	// This method is responsible to modify the funcionario's value
	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

	// This method is responsible to access the dia's value
	public int getDia()
	{
		return dia;
	}

	// This method is responsible to modify the dia's value
	public void setDia(int dia)
	{
		this.dia = dia;
	}

	// This method is responsible to access the mes's value
	public int getMes()
	{
		return mes;
	}

	// This method is responsible to modify the mes's value
	public void setMes(int mes)
	{
		this.mes = mes;
	}

	// This method is responsible to access the ano's value
	public int getAno()
	{
		return ano;
	}

	// This method is responsible to modify the ano's value
	public void setAno(int ano)
	{
		this.ano = ano;
	}

}
