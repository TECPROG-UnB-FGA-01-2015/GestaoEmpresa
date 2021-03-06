/**********************************************************
 * File: ClientController.java
 * Purpose: Contains the Clients maintenance methods
**********************************************************/		

package controller;

import java.util.ArrayList;
import model.Client;

public class ClientController
{
    private static ArrayList<Client> clientList; // Describes all the clients registered on the system
    
    static {
    	clientList = new ArrayList<Client>();
    }

    // Constructor to initialize the controller of clients
    public ClientController()
    {
    	// Just initialize the object
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
        Client clientReturned = null; // Used to return the client matching the given name (not Case Sensitive)
        boolean exactReturned = false; // Indicates that the client matching the given name (Case Sensitive)
        
        for(Client client: clientList)
        {
        	// Describes the name of current supplier
        	String clientName = client.getName();
        	
        	// Describes the comparison of current client name with the name parameter  
        	boolean clientNameEquals = clientName.equalsIgnoreCase(name);
        	
        	// Converts the client name to lowercase
        	String clientNameToLowerCase = clientName.toLowerCase();
        	
            if(clientNameEquals == true)
            {
                clientReturned = client;
                exactReturned = true;
            }
            else if((clientNameToLowerCase.toLowerCase().contains(name.toLowerCase())) && ignoreCase == true)
            {
            	if(exactReturned != true)
				{
					clientReturned = client;
				}
				else
				{
					// Nothing to Do
				}	
            }
            else
            {
            	// Nothing to do
            }
        }
        
        return clientReturned;
    }
}
