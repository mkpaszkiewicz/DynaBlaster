package paszkiewicz.marcin.model.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;

public class Multiplayer extends BasicGameState
{   
    private Model model;
    
    public Multiplayer(Model model)
    {
        this.model = model;
    }
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        // TODO Auto-generated method stub
        
    }

    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        // TODO Auto-generated method stub
        
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getID()
    {
        return GameState.MULTIPLAYER.ordinal();
    }
}
