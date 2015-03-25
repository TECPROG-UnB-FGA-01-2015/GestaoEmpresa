package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;
import view.TelaEstoque;

public class ControleEstoque
{
    TelaEstoque telaEstoque;
    private ArrayList<Produto> listaProdutos;
    
    public ControleEstoque()
    {
        this.listaProdutos = new ArrayList<Produto>();
    }

    public ArrayList<Produto> getListaProdutos()
    {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos)
    {
        this.listaProdutos = listaProdutos;
    }
    
    public void adicionarProduto(Produto p)
    {
        listaProdutos.add(p);
    }
    public void removerProduto(Produto p)
    {
        listaProdutos.remove(p);
    }
    
    public Produto pesquisarProduto(String nome, boolean pesquisa)
    {
        int i=0;
        Produto volta = null;
        Produto voltaExata = null;
        for(Produto p:listaProdutos)
        {
            if(p.getCodigo().toLowerCase().contains(nome.toLowerCase())&&pesquisa==true)
            {
                i++;
                volta = p;
            }
            
            if(p.getCodigo().equalsIgnoreCase(nome))
            {
                voltaExata = p;
            }
            
            if(p.getDescricao().toLowerCase().contains(nome.toLowerCase())&&pesquisa==true)
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
            JOptionPane.showMessageDialog(telaEstoque, "Mais de um resultado encontrado","Atenção" ,JOptionPane.INFORMATION_MESSAGE);
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