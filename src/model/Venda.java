/***********************************************************
 * File: Venda.java
 * Purpose: Responsible to get the Client's info to
 * 			sell Products with a given Date
***********************************************************/
package model;

import java.util.ArrayList;

public class Venda extends Transacao
{
	private Cliente cliente;

	public Venda(Cliente cliente, ArrayList<Produto> listaVenda, double preco,
			Funcionario funcionario, int dia, int mes, int ano)
	{
		super(listaVenda, preco, funcionario, dia, mes, ano);
		this.cliente = cliente;
	}

	public Cliente getCliente()
	{
		return cliente;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
}
