package paszkiewicz.marcin.core.impl;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.controller.ControllerStrategy;
import paszkiewicz.marcin.controller.impl.ControllerStrategyImpl;
import paszkiewicz.marcin.controller.impl.MainMenuController;
import paszkiewicz.marcin.controller.impl.MultiplayerController;
import paszkiewicz.marcin.controller.impl.SingleGameController;
import paszkiewicz.marcin.controller.listener.KeyListenerImpl;
import paszkiewicz.marcin.core.ApplicationContainer;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.model.impl.GameModelImpl;

public class GameCoreImpl implements GameCore
{
    protected ApplicationContainer application;

    protected GameModel gameModel;

    protected ControllerStrategy controllerStrategy;

    protected Map<GameState, Controller> stateToControllerMap;

    public GameCoreImpl()
    {
        this.gameModel = new GameModelImpl("Dyna Blaster");
        initStateToControllerMap();

        Controller defaultController = stateToControllerMap.get(GameState.MAINMENU);
        this.controllerStrategy = new ControllerStrategyImpl(defaultController);
    }

    @Override
    public void init() throws SlickException
    {
        int screenWidth = Display.getDisplayMode().getWidth();
        int screenHeight = Display.getDisplayMode().getHeight();

        application = new ApplicationContainer(this.gameModel, screenWidth, screenHeight, true);
        //application = new ApplicationContainer(this.gameModel, 600, 600, false);
        application.setShowFPS(false);
        // application.setMouseGrabbed(true);
        application.setAlwaysRender(true);
    }

    @Override
    public void run() throws SlickException
    {
        gameModel.playMusic();
        application.addKeyListener(new KeyListenerImpl(controllerStrategy));
        application.start();
    }

    @Override
    public void exit()
    {
        application.exit();
    }

    @Override
    public void enterState(GameState gameState)
    {
        controllerStrategy.set(stateToControllerMap.get(gameState));
        gameModel.enterState(gameState.ordinal());
    }

    private void initStateToControllerMap()
    {
        this.stateToControllerMap = new HashMap<GameState, Controller>();
        this.stateToControllerMap.put(GameState.MAINMENU, new MainMenuController(this, gameModel));
        this.stateToControllerMap.put(GameState.SINGLEGAME, new SingleGameController(this, gameModel));
        this.stateToControllerMap.put(GameState.MULTIPLAYER, new MultiplayerController(this, gameModel));
    }
}
