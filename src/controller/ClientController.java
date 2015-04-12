/**********************************************************
 * File: ClientController.java
 * Purpose: Contains the Clients maintenance methods
**********************************************************/		

package controller;

import java.util.ArrayList;
import model.Client;
import view.TelaContatos;

public class ClientController
{
    TelaContatos telaContatos;
    private static ArrayList<Client> clientList;

    // Constructor of the ClientController's class
    public ClientController()
    {
        clientList = new ArrayList<Client>();
    }

    // Access and returns the property clientList
    public static ArrayList<Client> getClientList()
    {
        return clientList;
    }

    // Sets a new value for the clientList property
    public static void setListaCliente(ArrayList<Client> clientList)
    {
    	ClientController.clientList = clientList;
    }
    
    // Adds a client to the clientList
    public void addCliente(Client cliente)
    {
        clientList.add(cliente);
    }
    
    // Removes a client of the clientList
    public void removeCliente(Client cliente)
    {
        clientList.remove(cliente);
    }
    
    // Search for a client in the clientList with a given name
    public Client searchCliente(String name, boolean search)
    {
        Client returned = null;
        Client exactReturned = null;
        int i = 0;
        for(Client cliente: clientList)
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
