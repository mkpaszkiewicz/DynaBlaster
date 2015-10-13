package paszkiewicz.marcin.core;

import java.util.concurrent.Semaphore;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

public class ApplicationContainer extends AppGameContainer
{
    private Semaphore inputInitialized = new Semaphore(0);

    public ApplicationContainer(Game game) throws SlickException
    {
        super(game);
    }

    public ApplicationContainer(Game game, int width, int height, boolean fullscreen) throws SlickException
    {
        super(game, width, height, fullscreen);
    }
    
    public void addKeyListener(final KeyListener keyListener)
    {
        new Thread() {
            public void run()
            {
                try
                {
                    inputInitialized.acquire();
                    ApplicationContainer.this.getInput().addKeyListener(keyListener);
                    inputInitialized.release();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    
    @Override
    protected void setup() throws SlickException
    {
        super.setup();
        inputInitialized.release();
    }
}
