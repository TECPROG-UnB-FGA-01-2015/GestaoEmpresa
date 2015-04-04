package model;

import java.util.ArrayList;

public class FornecedorJuridico extends Fornecedor
{
	private String razaoSocial;
	private String cnpj;

	/* Constructor to receive all the attributes as parameters and initialize the
	 * object FornecedorJuridico*/
	public FornecedorJuridico(String razaoSocial,
							  String cnpj,
							  String nome,
							  String telefone,
							  String celular,
							  ArrayList<Produto> listaProduto,
							  Endereco umEndereco)
	{
		super(nome, telefone, celular, listaProduto, umEndereco);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	// Method to return the content of attribute razaoSocial
	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	// Method to set a content on variable razaoSocial
	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	// Method to return the content of attribute cnpj
	public String getCnpj()
	{
		return cnpj;
	}

	// Method to set a content on variable cnpj
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

}
