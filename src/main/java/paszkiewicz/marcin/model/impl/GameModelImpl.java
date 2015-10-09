package paszkiewicz.marcin.model.impl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.menu.Menu;
import paszkiewicz.marcin.menu.MenuField;
import paszkiewicz.marcin.menu.MenuFieldName;
import paszkiewicz.marcin.menu.MenuFieldPointer;
import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.model.game.state.MainMenu;
import paszkiewicz.marcin.model.game.state.Multiplayer;
import paszkiewicz.marcin.model.game.state.SingleGame;
import paszkiewicz.marcin.util.GraphicPrototypeFactory;
import paszkiewicz.marcin.util.SlickFactory;
import paszkiewicz.marcin.view.View;
import paszkiewicz.marcin.view.graphic.Drawable;
import paszkiewicz.marcin.view.impl.ViewImpl;

public class GameModelImpl extends StateBasedGame implements GameModel
{
    private static final int INITIAL_STATE_ID = GameState.MAINMENU.ordinal();
    private static final String MUSIC_RESOURCE = "sounds/Pisarz_milosci_midi.ogg";
    
    protected Music music;
    
    protected Game game;
    
    protected Menu menu;
    
    public GameModelImpl(String name)
    {
        super(name);
        this.music = SlickFactory.createMusic(MUSIC_RESOURCE);
        this.menu = new Menu();
    }
    
    @Override
    public void update(int delta)
    {
        game.update(delta);        
    }
    
    @Override
    public Game getGame()
    {
        return game;
    }
    
    @Override
    public void startNewGame(Game game)
    {
        this.game = game;
    }
    
    @Override
    public Menu getMenu()
    {
        return menu;
    }
    
    @Override
    public void initMenu()
    {
        MenuField resume = new MenuField(MenuFieldName.RESUME, GraphicPrototypeFactory.createResumeGraphic());
        MenuField singleGame = new MenuField(MenuFieldName.SINGLE_GAME, GraphicPrototypeFactory.createSingleGameGraphic());
        MenuField multiplayer = new MenuField(MenuFieldName.MULTIPLAYER, GraphicPrototypeFactory.createMultiplayerGraphic());
        MenuField exit = new MenuField(MenuFieldName.EXIT, GraphicPrototypeFactory.createExitGraphic());
        MenuFieldPointer menuFieldPointer = new MenuFieldPointer(singleGame, GraphicPrototypeFactory.createMenuFieldPointerGraphic());
        
        float space = singleGame.getGraphic().getHeight();
        
        menuFieldPointer.setSpace(space);
        
        menu.addField(resume, 0);
        menu.setFieldVisibility(MenuFieldName.RESUME, false);
        menu.addField(singleGame, 1);
        menu.addField(multiplayer, 2);
        menu.addField(exit, 3);
        menu.setFieldPointer(menuFieldPointer);
        menu.setSpace(space);
    }

    @Override
    public void disableMenuField(String name)
    {
        menu.setFieldVisibility(name, false);
    }

    @Override
    public void enableMenuField(String name)
    {
        menu.setFieldVisibility(name, true);
    }
    
    @Override
    public void playMusic()
    {
        music.loop();
    }
    
    @Override
    public void pauseMusic()
    {
        music.pause();
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {
        View view = new ViewImpl();
        addState(new MainMenu(this, view));
        addState(new SingleGame(this, view));
        addState(new Multiplayer(this, view));
        
        enterState(INITIAL_STATE_ID);
    }
}
