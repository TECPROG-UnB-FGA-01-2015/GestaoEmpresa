/***********************************************************
 * File: ControleTransacao.java
 * Purpose: Responsible to get the Transaction's info to
 * 			add, remove and list Products sales.
 ***********************************************************/

package controller;

import java.util.ArrayList;
import model.Transaction;

public class ControleTransacao
{
	private ArrayList<Transaction> listaVenda;

	/* This method is responsible to create a new ArrayList called listaVenda
	 * from the model class Transacao */
	public ControleTransacao()
	{
		this.listaVenda = new ArrayList<Transaction>();
	}

	// This method is responsible to access the listaVenda's private value from the ArrayList
	public ArrayList<Transaction> getListaVenda()
	{
		return listaVenda;
	}

	// This method is responsible to modify the listaVenda's private value from the ArrayList
	public void setListaVendas(ArrayList<Transaction> listaVendas)
	{
		this.listaVenda = listaVendas;
	}

	/* This method is responsible to add sales on the listaVenda's arraylist on
	 * the model class Transacao */
	public void adicionarVenda(Transaction v)
	{
		listaVenda.add(v);
	}

	/* This method is responsible to delete the added sales on the listaVenda's
	 * arraylist on the model class Transacao */
	public void removerVenda(Transaction v)
	{
		listaVenda.remove(v);
	}

}
