package paszkiewicz.marcin.model.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.view.View;

public class SingleGame extends AbstractGameState
{
    public SingleGame(Model model, View view)
    {
        super(model, view);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        view.drawGame(model.getGame(), graphics);
    }

    @Override
    public int getID()
    {
        return GameState.SINGLEGAME.ordinal();
    }
}
