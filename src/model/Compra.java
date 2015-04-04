/***********************************************************
 * File: Compra.java
 * Purpose: Responsible to get the Supplier's info to
 * 			buy Products with a given Date
***********************************************************/
package model;

import java.util.ArrayList;

public class Compra extends Transacao
{
	private Fornecedor fornecedor;

	public Compra(Fornecedor fornecedor, ArrayList<Produto> listaVenda,
			double preco, Funcionario funcionario, int dia, int mes, int ano)
	{
		super(listaVenda, preco, funcionario, dia, mes, ano);
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor()
	{
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor)
	{
		this.fornecedor = fornecedor;
	}

}
