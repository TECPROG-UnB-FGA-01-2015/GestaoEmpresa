package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;
import view.ContactView;

public class ClientController
{
    ContactView contactView;
    private static ArrayList<Client> clientList;
    
    public ClientController()
    {
        clientList = new ArrayList<Client>();
    }

    public static ArrayList<Client> getListaClient()
    {
        return clientList;
    }

    public static void setListaClient(ArrayList<Client> clientList)
    {
        ClientController.clientList = clientList;
    }
    
    public void addClient (Client client)
    {
        clientList.add(client);
    }
    
    public void removeClient (Client client)
    {
        clientList.remove(client);
    }
    
    public Client searchClient(String name, boolean search)
    {
        Client return = null;
        Client exactReturn = null;
        int i = 0;
        for(Client client: clientList)
        {
            if((client.getNome().equalsIgnoreCase(name)))
            {
                exactReturn = client;
                i = i + 1;
            }
            else if((client.getNome().toLowerCase().contains(name.toLowerCase())) && search==true)
            {
                return = client;
                i = i + 1;
            }
        }
        
        if(exactReturn != null)
        {
            return exactReturn;
        }
        else if(return != null)
        {
            return return;
        }
        return null;
    }
    
}
