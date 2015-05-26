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
    
    static {
    	clientList = new ArrayList<Client>();
    }

    // Constructor default of the ClientController's class
    public ClientController()
    {
      
    }

    // Access and returns the property clientList
    public ArrayList<Client> getClientList()
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
        	// Variable to get the name of current supplier
        	String clientName = client.getName();
        	
        	// Variable to return the comparison of current client name with the name parameter  
        	boolean clientNameEquals = clientName.equalsIgnoreCase(name);
        	
        	// Variable to pass the client name to lowercase
        	String clientNameToLowerCase = clientName.toLowerCase();
        	
            if(clientNameEquals == true)
            {
                exactReturned = client;
            }
            else if((clientNameToLowerCase.toLowerCase().contains(name.toLowerCase())) && ignoreCase == true)
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
