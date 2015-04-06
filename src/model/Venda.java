/***********************************************************
 * File: Venda.java
 * Purpose: Responsible to get the Client's info to
 * 			sell Products with a given Date.
 **********************************************************/

package model;

import java.util.ArrayList;

public class Venda extends Transacao
{
	private Cliente cliente;

	/* This constructor method is responsible to receive some attributes as
	 * parameters to initialize the Venda's objects and to call the parent
	 * constructor (superclass) from Transacao class with its arguments */
	public Venda(Cliente cliente,
	             ArrayList<Produto> listaVenda,
	             double preco,
	             Funcionario funcionario,
	             int dia,
	             int mes,
	             int ano)
	{
		super(listaVenda, preco, funcionario, dia, mes, ano);
		this.cliente = cliente;
	}

	// This method is responsible to access the cliente's private value
	public Cliente getCliente()
	{
		return cliente;
	}

	// This method is responsible to modify the cliente's private value
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
}
