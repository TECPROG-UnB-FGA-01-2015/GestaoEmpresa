/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import view.TelaContatos;


public class ControleCliente {
    
    TelaContatos telaContatos;
    private static ArrayList<Cliente> listaCliente;
    

    public ControleCliente() {
        listaCliente = new ArrayList<Cliente>();
        
    }

    public static ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public static void setListaCliente(ArrayList<Cliente> listaCliente) {
        ControleCliente.listaCliente = listaCliente;
    }
    
    public void adicionarCliente (Cliente c){
        listaCliente.add(c);
    }
    public void removerCliente (Cliente c){
        listaCliente.remove(c);
    }
    
    public Cliente pesquisarCliente(String nome,boolean pesquisa){
        Cliente volta = null;
        Cliente voltaExata = null;
        int i=0;
        for(Cliente c: listaCliente)
        {
            if((c.getNome().equalsIgnoreCase(nome)))
            {
                voltaExata = c;
                i++;
            }
            else if((c.getNome().toLowerCase().contains(nome.toLowerCase()))&&pesquisa==true)
            {
                volta = c;
                i++;
            }
        }
        
        if(voltaExata!=null)
            return voltaExata;
        else if(volta!=null)
            return volta;
        return null;
    }
    
}
