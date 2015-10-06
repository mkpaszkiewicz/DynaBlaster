package paszkiewicz.marcin.model.impl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.game.state.GameState;

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
        enterState(INITIAL_STATE_ID);
    }
}
