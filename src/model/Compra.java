/***********************************************************
 * File: Compra.java
 * Purpose: Responsible to get the Supplier's info to
 * 			buy Products with a given Date
 **********************************************************/
package model;

import java.util.ArrayList;

public class Compra extends Transacao
{
	private Fornecedor fornecedor;

	/* This constructor method is responsible to receive some attributes
	 * as parameters to initialize the Compra's objects and to call the parent
	 * constructor (superclass) from Transacao class with its arguments 
	 */
	public Compra(Fornecedor fornecedor, ArrayList<Produto> listaVenda,
			double preco, Funcionario funcionario, int dia, int mes, int ano)
	{
		super(listaVenda, preco, funcionario, dia, mes, ano);
		this.fornecedor = fornecedor;
	}

	// This method is responsible to access the fornecedor's private value
	public Fornecedor getFornecedor()
	{
		return fornecedor;
	}

	// This method is responsible to modify the fornecedor's private value
	public void setFornecedor(Fornecedor fornecedor)
	{
		this.fornecedor = fornecedor;
	}

}
