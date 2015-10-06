package paszkiewicz.marcin.model.impl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.state.GameState;

public class GameModel extends StateBasedGame implements Model
{
    private static final int INITIAL_STATE_ID = GameState.MAINMENU.ordinal();
    
    public GameModel(String name)
    {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {
        enterState(INITIAL_STATE_ID);
    }
}
