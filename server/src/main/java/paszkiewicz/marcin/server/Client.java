package paszkiewicz.marcin.server;

import java.io.*;
import java.net.*;

public class Client implements Runnable
{
	private static final int KEY_ESCAPE = 1;

	public Socket socket;
	
	private ObjectOutputStream output;
	
	private ObjectInputStream input;
	
	private Client opponent;
	
	Client(Socket socket)
	{
		try
		{
			this.socket = socket;
			this.output = new ObjectOutputStream(socket.getOutputStream());
			this.input = new ObjectInputStream(socket.getInputStream());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{
		waitIfNoOpponent();
		handleTransmission();
		closeConnection();
		System.out.println("End of transmission");
	}

	private void handleTransmission()
	{
		try
		{
			while(!socket.isClosed())
			{	
				Event event;
				event = (Event) input.readObject();
				opponent.send(event);
				if(event.keyCode == KEY_ESCAPE)
					break;
			}
		}
		catch (IOException e)
		{
			System.out.println("Connection with client has been lost.");		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void send(Event event)
	{
		write(event);
	}

	public synchronized void addOpponent(Client client, String position)
	{
		this.opponent = client;
		write(position);
		notify();
	}
	
	private synchronized void waitIfNoOpponent()
	{
		try
		{
			if(opponent == null)
			{
				wait();
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	private void write(Object object)
	{
		try
		{
			if(!socket.isClosed())
			{
				output.writeObject(object);
				output.flush();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void closeConnection()
	{
		try
		{
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
