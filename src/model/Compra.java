/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

public class Compra extends Transacao {
    private Fornecedor fornecedor;

    public Compra(Fornecedor fornecedor, ArrayList<Produto> listaVenda, double preco, Funcionario funcionario, int dia, int mes, int ano) {
        super(listaVenda, preco, funcionario, dia, mes, ano);
        this.fornecedor = fornecedor;
    }
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
