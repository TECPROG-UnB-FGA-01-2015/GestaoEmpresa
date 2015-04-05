/**********************************************************
 * File: Cliente.java
 * Purpose: Holds all the attributes and methods of the
 * 		    subclass FornecedorFisico.
 *********************************************************/

package model;

import java.util.ArrayList;

public class FornecedorFisico extends Fornecedor
{
	private String cpf;
	private String rg;

	/* Constructor to receive all the attributes as parameters and initialize the
	 * object FornecedorFisico*/
	public FornecedorFisico(String cpf,
							String rg,
							String nome,
							String telefone,
							String celular,
							ArrayList<Produto> listaProduto,
							Endereco umEndereco)
	{
		super(nome, telefone, celular, listaProduto, umEndereco);
		this.cpf = cpf;
		this.rg = rg;
	}

	// Method to return the content of attribute cpf
	public String getCpf()
	{
		return cpf;
	}

	// Method to set a content on variable cpf
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	// Method to return the content of attribute rg
	public String getRg()
	{
		return rg;
	}

	// Method to set a content on variable rg
	public void setRg(String rg)
	{
		this.rg = rg;
	}

}