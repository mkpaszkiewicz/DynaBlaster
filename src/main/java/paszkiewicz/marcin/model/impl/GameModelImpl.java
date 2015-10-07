package paszkiewicz.marcin.model.impl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.model.game.state.MainMenu;
import paszkiewicz.marcin.model.game.state.Multiplayer;
import paszkiewicz.marcin.model.game.state.SingleGame;

public class GameModelImpl extends StateBasedGame implements GameModel
{
    private static final int INITIAL_STATE_ID = GameState.MAINMENU.ordinal();
    
    public GameModelImpl(String name)
    {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {
        addState(new MainMenu());
        addState(new SingleGame());
        addState(new Multiplayer());
        
        enterState(INITIAL_STATE_ID);
    }
}
