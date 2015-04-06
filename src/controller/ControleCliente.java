/**********************************************************
 * File: ControleCliente.java
 * Purpose: Contains the Clients maintenance methods
**********************************************************/		

package controller;

import java.util.ArrayList;
import model.Cliente;
import view.TelaContatos;

public class ControleCliente
{
    TelaContatos telaContatos;
    private static ArrayList<Cliente> clientList;

    // Constructor of the ClientController's class
    public ControleCliente()
    {
        clientList = new ArrayList<Cliente>();
    }

    // Access and returns the property clientList
    public static ArrayList<Cliente> getListaCliente()
    {
        return clientList;
    }

    // Sets a new value for the clientList property
    public static void setListaCliente(ArrayList<Cliente> clientList)
    {
    	ControleCliente.clientList = clientList;
    }
    
    // Adds a client to the clientList
    public void addCliente(Cliente cliente)
    {
        clientList.add(cliente);
    }
    
    // Removes a client of the clientList
    public void removerCliente(Cliente cliente)
    {
        clientList.remove(cliente);
    }
    
    // Search for a client in the clientList with a given name
    public Cliente pesquisarCliente(String name, boolean search)
    {
        Cliente returned = null;
        Cliente exactReturned = null;
        int i = 0;
        for(Cliente cliente: clientList)
        {
            if((cliente.getName().equalsIgnoreCase(name)))
            {
                exactReturned = cliente;
                i = i + 1;
            }
            else if((cliente.getName().toLowerCase().contains(name.toLowerCase())) && search == true)
            {
                returned = cliente;
                i = i + 1;
            }
        }
        
        if(exactReturned != null)
        {
            return exactReturned;
        }
        else if(returned != null)
        {
            return returned;
        }
        return null;
    }
    
}
