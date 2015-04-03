/**********************************************************
 * File: ControleDespesa.java
 * Purpose: Contains the Despesa maintenance methods
**********************************************************/
package controller;

import java.util.ArrayList;
import model.Despesa;

public class ControleDespesa
{
    private ArrayList<Despesa> listaGasto;

    // Constructor to instance ControleDespesa with the attribute listaGasto 
    public ControleDespesa()
    {
        this.listaGasto = new ArrayList<Despesa>();
    }

    // Method to return the content of attribute listaGasto
    public ArrayList<Despesa> getListaGasto()
    {
        return listaGasto;
    }
    
    // Method to set a content on variable listaGasto
    public void setListaGasto(ArrayList<Despesa> listaGasto)
    {
        this.listaGasto = listaGasto;
    }
    
    // Method to insert an element which is a Despesa type
    public void adicionarGasto(Despesa g)
    {
        listaGasto.add(g);
    }
    
    // Method to remove an element which is a Despesa type
    public void removerGasto(Despesa g)
    {
        listaGasto.remove(g);
    }
    
    /* Method to search an element which is a Despesa type by passing as a parameter a
     * name
     */
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
