/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import model.Despesa;

public class ControleDespesa
{
    private ArrayList<Despesa> listaGasto;

    public ControleDespesa()
    {
        this.listaGasto = new ArrayList<Despesa>();
    }

    public ArrayList<Despesa> getListaGasto()
    {
        return listaGasto;
    }

    public void setListaGasto(ArrayList<Despesa> listaGasto)
    {
        this.listaGasto = listaGasto;
    }
    
    public void adicionarGasto(Despesa g)
    {
        listaGasto.add(g);
    }
    
    public void removerGasto(Despesa g)
    {
        listaGasto.remove(g);
    }
    
    public Despesa pesquisarGasto(String nome)
    {
        for(Despesa g: listaGasto)
        {
            if(g.getNome().equalsIgnoreCase(nome))
            {
                return g;
            }
        }
        return null;
    }
   
}
