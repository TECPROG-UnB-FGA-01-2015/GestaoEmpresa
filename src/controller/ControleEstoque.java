package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;
import view.TelaEstoque;

public class ControleEstoque
{
    TelaEstoque telaEstoque;
    private ArrayList<Produto> listaProdutos;
    
    // Constructor to instance ControleEstoque with the attribute listaProdutos
    public ControleEstoque()
    {
        this.listaProdutos = new ArrayList<Produto>();
    }

    // Method to return the content of attribute listaProdutos
    public ArrayList<Produto> getListaProdutos()
    {
        return listaProdutos;
    }

    // Method to set a content on variable listaProdutos
    public void setListaProdutos(ArrayList<Produto> listaProdutos)
    {
        this.listaProdutos = listaProdutos;
    }
    
    // Method to insert an element which is a Produto type
    public void adicionarProduto(Produto p)
    {
        listaProdutos.add(p);
    }
   
    // Method to remove an element which is a Produto type
    public void removerProduto(Produto p)
    {
        listaProdutos.remove(p);
    }
    
    /* Method to search an element which is a Produto type by passing as a parameter
     * a nome
     */
    public Produto pesquisarProduto(String nome, boolean pesquisa)
    {
        int i=0;
        Produto volta = null;
        Produto voltaExata = null;
        
        for(Produto p:listaProdutos)
        {
            if(p.getCodigo().toLowerCase().contains(nome.toLowerCase())&&pesquisa==
            		true)
            {
                i++;
                volta = p;
            }
            
            if(p.getCodigo().equalsIgnoreCase(nome))
            {
                voltaExata = p;
            }
            
            if(p.getDescricao().toLowerCase().contains(nome.toLowerCase())&&pesquisa==
            		true)
            {
                volta = p;
                i++;
            }
            
            if(p.getDescricao().equalsIgnoreCase(nome))
            {
                voltaExata = p;
            }
            
        }
        
        if(i>1&&pesquisa==true)
        {
            JOptionPane.showMessageDialog(telaEstoque, "Mais de um resultado"
            		+ "encontrado","Atenção" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(voltaExata != null)
        {
            return voltaExata;
        }
        
        else if(volta != null)
        {
            return volta;
        }
        
        return null;
        
    }
    
}