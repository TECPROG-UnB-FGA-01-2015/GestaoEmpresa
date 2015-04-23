/**********************************************************
 * File: ClientController.java
 * Purpose: Contains the Clients maintenance methods
**********************************************************/		

package controller;

import java.util.ArrayList;
import model.Client;

public class ClientController
{
    private static ArrayList<Client> clientList; // Holds all the clients registered on the system

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
    public static void setClientList(ArrayList<Client> clientList)
    {
    	ClientController.clientList = clientList;
    }
    
    // Adds a client to the clientList
    public void addClient(Client client)
    {
        clientList.add(client);
    }
    
    // Removes a client of the clientList
    public void removeClient(Client client)
    {
        clientList.remove(client);
    }
    
    // Search for a client in the clientList with a given name
    public Client searchClient(String name, boolean ignoreCase)
    {
        Client returned = null; // Used to return the client matching the given name (not Case Sensitive)
        Client exactReturned = null; // Used to return the client matching the given name (Case Sensitive)
        
        for(Client client: clientList)
        {
            if((client.getName().equalsIgnoreCase(name)))
            {
                exactReturned = client;
            }
            else if((client.getName().toLowerCase().contains(name.toLowerCase())) && ignoreCase == true)
            {
                returned = client;
            }
            else
            {
            	// Nothing to do
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
        else
        {
        	return null;
        }
    }
    
}
