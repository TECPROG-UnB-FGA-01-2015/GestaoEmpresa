/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */

package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fornecedor;
import view.TelaContatos;

public class ControleFornecedor
{

	private static ArrayList<Fornecedor> listaFornecedor;
	TelaContatos telaContatos;

	// Constructor to instance ControleFornecedor with the attribute listaFornecedor
	public ControleFornecedor()
	{
		this.listaFornecedor = new ArrayList<Fornecedor>();
	}

	// Method to return the content of attribute listaFornecedor
	public ArrayList<Fornecedor> getListaFornecedor()
	{
		return listaFornecedor;
	}

	// Method to set a content on variable listaForncedor
	public void setListaFornecedor(ArrayList<Fornecedor> listaFornecedor)
	{
		this.listaFornecedor = listaFornecedor;
	}

	// Method to insert a supplier to attribute listaFornecedor
	public void adicionarFornecedor(Fornecedor f)
	{
		listaFornecedor.add(f);
	}

	// Method for removing an attribute provider listaFornecedor
	public void removerFornecedor(Fornecedor f)
	{
		listaFornecedor.remove(f);
	}

	// Method to find a supplier from the parameter name
	public Fornecedor pesquisarFornecedor(String nome, boolean pesquisa)
	{
		Fornecedor volta = null;
		Fornecedor voltaExata = null;
		int i = 0;
		for(Fornecedor f : listaFornecedor)
		{
			if((f.getNome().equalsIgnoreCase(nome)))
			{
				voltaExata = f;
				i++;
			}
			else if((f.getNome().toLowerCase().contains(nome.toLowerCase())) && pesquisa == true)
			{
				volta = f;
				i++;
			}
			else
			{
				// Nothing to Do
			}
		}

		if(voltaExata != null)
		{
			return voltaExata;
		}
		else if(volta != null)
		{
			return volta;
		}
		else
		{
			return null;
		}
	}

}
