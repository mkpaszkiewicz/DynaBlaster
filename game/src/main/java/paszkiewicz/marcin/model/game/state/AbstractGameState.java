package paszkiewicz.marcin.model.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.view.View;

public abstract class AbstractGameState extends BasicGameState
{
    protected Model model;
    
    protected View view;

    public AbstractGameState(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        model.update(delta);
    }
}
