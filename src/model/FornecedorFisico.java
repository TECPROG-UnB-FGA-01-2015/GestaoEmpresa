package model;

import java.util.ArrayList;

public class FornecedorFisico extends Fornecedor
{
	private String cpf;
	private String rg;

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

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

}