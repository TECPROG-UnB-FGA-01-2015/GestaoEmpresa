/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 * 
 * @author Ricardo
 */
public class Transacao
{
	protected ArrayList<Produto> listaVenda;
	protected double preco;
	protected Funcionario funcionario;
	protected int dia;
	protected int mes;
	protected int ano;

	public Transacao(ArrayList<Produto> listaVenda, double preco,
			Funcionario funcionario, int dia, int mes, int ano)
	{
		this.listaVenda = listaVenda;
		this.preco = preco;
		this.funcionario = funcionario;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public ArrayList<Produto> getListaVenda()
	{
		return listaVenda;
	}

	public void setListaVenda(ArrayList<Produto> listaVenda)
	{
		this.listaVenda = listaVenda;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(double preco)
	{
		this.preco = preco;
	}

	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

	public int getDia()
	{
		return dia;
	}

	public void setDia(int dia)
	{
		this.dia = dia;
	}

	public int getMes()
	{
		return mes;
	}

	public void setMes(int mes)
	{
		this.mes = mes;
	}

	public int getAno()
	{
		return ano;
	}

	public void setAno(int ano)
	{
		this.ano = ano;
	}

}
