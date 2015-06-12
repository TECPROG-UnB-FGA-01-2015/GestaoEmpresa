package controller;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClientControllerTest extends TestCase
{
	Client client;
	ArrayList<Client> clientList;
	ClientController clientController = new ClientController(); 

	@Before
	public void setUp() throws Exception
	{
		client = new Client("Teste", null, "123", "1234");
		clientList = new ArrayList<Client>();
	}

	@After
	public void tearDown() throws Exception
	{
		clientList.clear();
	}

	@Test
	public void testAddClient()
	{
		clientController.addClient(client);
		
		clientList = clientController.getClientList();
		int listSize = clientList.size();
		assertEquals(1,listSize);	
	}
	
	@Test
	public void testRemoveClient()
	{
		clientController.addClient(client);
		
		clientList = clientController.getClientList();
		clientController.removeClient(client);
		
		int listSize = clientList.size();
		assertEquals(0,listSize);
	}
	
}
