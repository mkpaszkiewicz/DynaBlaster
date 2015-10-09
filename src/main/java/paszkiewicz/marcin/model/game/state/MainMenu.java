package paszkiewicz.marcin.model.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.view.View;

public class MainMenu extends AbstractGameState
{
    public MainMenu(Model model, View view)
    {
        super(model, view);
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        model.initMenu();
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        view.drawMainMenu(model.getMenu(), graphics);
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
    }
    
    @Override
    public int getID()
    {
        return GameState.MAINMENU.ordinal();
    }


}
