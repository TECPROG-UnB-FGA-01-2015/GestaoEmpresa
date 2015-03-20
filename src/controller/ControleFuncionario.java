/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.TelaContatos;

public class ControleFuncionario {
    
    private static ArrayList<Funcionario> listaFuncionario;
    TelaContatos telaContatos;

    public ControleFuncionario() {
        listaFuncionario = new ArrayList<Funcionario>();
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    
    public void adicionarFuncionario(Funcionario f){
        listaFuncionario.add(f);
    }
    public void removerFuncionario(Funcionario f){
        listaFuncionario.remove(f);
    }
    
    public Funcionario pesquisarFuncionario(String nome,boolean pesquisa){
        Funcionario volta = null;
        Funcionario voltaExata = null;
        int i=0;
        for(Funcionario f: listaFuncionario)
        {
            if((f.getNome().equalsIgnoreCase(nome)))
            {
                voltaExata = f;
                i++;
            }
            else if((f.getNome().toLowerCase().contains(nome.toLowerCase()))&&pesquisa==true)
            {
                volta = f;
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
