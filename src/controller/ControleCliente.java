package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;
import view.ContactView;

public class ClientController
{
    ContactView contactView;
    private static ArrayList<Client> clientList;

    // Constructor of the ClientController's class
    public ClientController()
    {
        clientList = new ArrayList<Client>();
    }

    // Access and returns the property clientList
    public static ArrayList<Client> getListaClient()
    {
        return clientList;
    }

    // Sets a new value for the clientList property
    public static void setListaClient(ArrayList<Client> clientList)
    {
        ClientController.clientList = clientList;
    }
    
    // Adds a client to the clientList
    public void addClient (Client client)
    {
        clientList.add(client);
    }
    
    // Removes a client of the clientList
    public void removeClient (Client client)
    {
        clientList.remove(client);
    }
    
    // Search for a client in the clientList with a given name
    public Client searchClient(String name, boolean search)
    {
        Client returned = null;
        Client exactReturned = null;
        int i = 0;
        for(Client client: clientList)
        {
            if((client.getName().equalsIgnoreCase(name)))
            {
                exactReturned = client;
                i = i + 1;
            }
            else if((client.getName().toLowerCase().contains(name.toLowerCase())) && search == true)
            {
                returned = client;
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
