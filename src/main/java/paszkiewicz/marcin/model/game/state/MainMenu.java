package paszkiewicz.marcin.model.game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.view.View;
import paszkiewicz.marcin.view.impl.MainMenuView;

public class MainMenu extends BasicGameState
{
    private View view;
    
    private Model model;
    
    public MainMenu(Model model)
    {
        this.model = model;
    }
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        view = new MainMenuView();
        model.initMenu();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException
    {
        view.render(model, graphics);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
    }

    @Override
    public int getID()
    {
        return GameState.MAINMENU.ordinal();
    }
}
