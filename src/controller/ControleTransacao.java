/***********************************************************
 * File: ControleTransacao.java
 * Purpose: Responsible to get the Transaction's info to
 * 			add, remove and list Products sales
***********************************************************/
package controller;

import java.util.ArrayList;
import model.Transacao;

public class ControleTransacao
{
	private ArrayList<Transacao> listaVenda;

	public ControleTransacao()
	{
		this.listaVenda = new ArrayList<Transacao>();
	}

	public ArrayList<Transacao> getListaVenda()
	{
		return listaVenda;
	}

	public void setListaVendas(ArrayList<Transacao> listaVendas)
	{
		this.listaVenda = listaVendas;
	}

	public void adicionarVenda(Transacao v)
	{
		listaVenda.add(v);
	}

	public void removerVenda(Transacao v)
	{
		listaVenda.remove(v);
	}

}
