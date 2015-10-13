package paszkiewicz.marcin.model.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.view.View;

public class Multiplayer extends AbstractGameState
{   
    public Multiplayer(Model model, View view)
    {
        super(model, view);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        view.draw(model.getGame(), graphics);
    }
    
    @Override
    public int getID()
    {
        return GameState.MULTIPLAYER.ordinal();
    }
}
