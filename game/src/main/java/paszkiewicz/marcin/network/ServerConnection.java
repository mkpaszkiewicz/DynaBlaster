package paszkiewicz.marcin.network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.controller.impl.OpponentController;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.impl.MultiplayerGame;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.server.Event;

public class ServerConnection implements Runnable
{
    private static String HOST = "localhost";

    private static int PORT = 2000;

    protected Socket connection;

    protected ObjectOutputStream output;

    protected ObjectInputStream input;

    protected boolean isListener = false;

    protected Controller opponentController;

    protected GameCore gameCore;

    protected Model model;

    public ServerConnection(GameCore gameCore, Model model)
    {
        this.opponentController = new OpponentController(gameCore, model);
        this.gameCore = gameCore;
        this.model = model;
    }

    @Override
    public void run()
    {
        try
        {
            connect();
            System.out.println("Connected");
            setOpponentIfAppeared();
            handleTransmision();
            closeConnection();
        }
        catch (IOException e)
        {
            System.out.println("Cannot connect.");
            gameCore.enterState(GameState.MAINMENU);
        }
    }

    protected void connect() throws IOException
    {
        System.out.println("Connecting...");
        String host = HOST;

        int port = PORT;

        InetAddress address = InetAddress.getByName(host);
        connection = new Socket(address, port);

        this.output = new ObjectOutputStream(connection.getOutputStream());
        this.input = new ObjectInputStream(connection.getInputStream());
    }

    private void setOpponentIfAppeared()
    {
        try
        {
            String str;
            str = (String) input.readObject();

            MultiplayerGame game = (MultiplayerGame) model.getGame();
            game.setStartingPositions(str);
            isListener = true;
            System.out.println("Found opponent.");
        }
        catch (EOFException e)
        {
            System.out.println("Connection with server has been lost.");
        }
        catch (IOException e)
        {
            System.out.println("Cancelled waiting for an opponent.");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void handleTransmision()
    {
        try
        {
            while (!connection.isClosed() && isListener)
            {
                Event event;
                event = (Event) input.readObject();

                if (event.pressed && event.keyCode == Input.KEY_ESCAPE)
                {
                    exitServer();
                    isListener = false;
                }

                if (event.pressed)
                    opponentController.serveKeyPressed(event.keyCode);
                else
                    opponentController.serveKeyReleased(event.keyCode);
            }
        }
        catch (EOFException e)
        {
            System.out.println("Connection with server has been lost.");
            isListener = false;
        }
        catch (IOException e)
        {
            System.out.println("Leaving game.");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void closeConnection()
    {
        try
        {
            connection.close();
            System.out.println("Connection closed");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void send(int keyCode, boolean pressed)
    {
        if( !hasListener())
        {
            return;
        }
        
        try
        {
            if (!connection.isClosed())
            {
                output.writeObject(new Event(keyCode, pressed));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        try
        {
            isListener = false;
            exitServer();
            input.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean hasListener()
    {
        return isListener;
    }

    protected void exitServer()
    {
        send(Input.KEY_ESCAPE, true);
    }
}