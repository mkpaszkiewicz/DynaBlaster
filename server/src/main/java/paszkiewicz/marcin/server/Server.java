package paszkiewicz.marcin.server;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;

public class Server
{  
	private static LinkedList<Client> clients;
	private static ServerSocket serverSocket;
	
	public static void main(String[] args)
	{		
		try
		{	
			//int port = Integer.parseInt(args[0]);
			int port = 2000;
			clients = new LinkedList<Client>();
			
			serverSocket = new ServerSocket(port);
			
			System.out.println("Server running.");
			while(true)
			{
				acceptClient();
				pairClients();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void acceptClient() throws IOException
	{
		Socket player = serverSocket.accept();
		Client client = new Client(player);
		Thread thread = new Thread(client);
		thread.start();
		clients.add(client);
		System.out.println("Client accepted.");
	}
	
	private static void pairClients()
	{
		if(clients.size() < 2)
		{
			return;
		}
		clients.get(0).addOpponent(clients.get(1), "top left");
		clients.get(1).addOpponent(clients.get(0), "bottom right");
		clients.removeFirst();
		clients.removeFirst();
		System.out.println("Clients paired.");
	}
}
