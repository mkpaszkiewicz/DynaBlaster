package paszkiewicz.marcin.core.impl;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.controller.ControllerStrategy;
import paszkiewicz.marcin.controller.impl.ControllerStrategyImpl;
import paszkiewicz.marcin.controller.impl.MainMenuController;
import paszkiewicz.marcin.controller.listener.KeyListenerImpl;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.impl.GameModelImpl;

public class GameCoreImpl implements GameCore
{
    private AppGameContainer application;

    private GameModel gameModel;

    private ControllerStrategy controllerStrategy;
    
    public GameCoreImpl()
    {
        this.gameModel = new GameModelImpl("Dyna Blaster");
        
        Controller defaultController = new MainMenuController();
        this.controllerStrategy = new ControllerStrategyImpl(defaultController);
    }

    public void init() throws SlickException
    {
        int screenWidth = Display.getDisplayMode().getWidth();
        int screenHeight = Display.getDisplayMode().getHeight();

        // application = new AppGameContainer(model, screenWidth, screenHeight, true);
        application = new AppGameContainer(this.gameModel, 600, 600, false);
        application.setShowFPS(false);
        //application.setMouseGrabbed(true);
        application.setAlwaysRender(true);
    }

    public void run() throws SlickException
    {   
        gameModel.playMusic();
        runKeyListener();
        application.start();
    }

    private void runKeyListener()
    {
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    try
                    {
                        application.getInput().addKeyListener(new KeyListenerImpl(controllerStrategy));
                        break;
                    }
                    catch(NullPointerException e)
                    {
                        //application has not started yet, try again
                    }
                }
            }
        }.start();
    }
}
