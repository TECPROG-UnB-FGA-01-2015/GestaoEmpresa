package controller;

import java.util.ArrayList;
import model.Transacao;

public class ControleTransacao
{
	private ArrayList<Transacao> listaVenda;

	/* This method is responsible to create a new ArrayList
	 * called listaVenda from the model class Transacao
	 */
	public ControleTransacao()
	{
		this.listaVenda = new ArrayList<Transacao>();
	}

	// This method is responsible to access the listaVenda's private value from the ArrayList
	public ArrayList<Transacao> getListaVenda()
	{
		return listaVenda;
	}

	// This method is responsible to modify the listaVenda's private value from the ArrayList
	public void setListaVendas(ArrayList<Transacao> listaVendas)
	{
		this.listaVenda = listaVendas;
	}

	/* This method is responsible to add sales on the listaVenda's arraylist
	 * on the model class Transacao
	 */
	public void adicionarVenda(Transacao v)
	{
		listaVenda.add(v);
	}

	/* This method is responsible to delete the added sales on the listaVenda's arraylist
	 * on the model class Transacao
	 */
	public void removerVenda(Transacao v)
	{
		listaVenda.remove(v);
	}

}
