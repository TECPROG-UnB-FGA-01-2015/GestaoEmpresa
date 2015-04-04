package model;

import java.util.ArrayList;

public class Fornecedor
{
	protected String nome;
	protected String telefone;
	protected String celular;
	protected ArrayList<Produto> listaProduto;
	protected Endereco endereco;
	
	
	/* Constructor to receive all the attributes as parameters and initialize the
	 * object Fornecedor*/
	public Fornecedor(String nome,
					  String telefone,
					  String celular,
					  ArrayList<Produto> listaProduto,
					  Endereco endereco)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.listaProduto = listaProduto;
		this.endereco = endereco;
	}
	
	// Method to return the content of attribute telefone
	public String getTelefone()
	{
		return telefone;
	}
	
	// Method to set a content on variable telefone
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	// Method to return the content of attribute celular
	public String getCelular()
	{
		return celular;
	}

	// Method to set a content on variable celular
	public void setCelular(String celular)
	{
		this.celular = celular;
	}

	// Method to return the content of attribute nome
	public String getNome()
	{
		return nome;
	}

	// Method to set a content on variable nome
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	// Method to return the content of attribute listaProduto
	public ArrayList<Produto> getListaProduto()
	{
		return listaProduto;
	}

	// Method to set a content on variable listaProduto
	public void setListaProduto(ArrayList<Produto> listaProduto)
	{
		this.listaProduto = listaProduto;
	}

	// Method to return the content of attribute endereco
	public Endereco getEndereco()
	{
		return endereco;
	}

	// Method to set a content on variable endereco
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}

}
