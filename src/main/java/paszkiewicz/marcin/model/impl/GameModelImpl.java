package paszkiewicz.marcin.model.impl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.component.Menu;
import paszkiewicz.marcin.component.MenuField;
import paszkiewicz.marcin.component.MenuFieldName;
import paszkiewicz.marcin.component.MenuFieldPointer;
import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.model.game.state.MainMenu;
import paszkiewicz.marcin.model.game.state.Multiplayer;
import paszkiewicz.marcin.model.game.state.SingleGame;
import paszkiewicz.marcin.util.GraphicPrototypeFactory;
import paszkiewicz.marcin.util.SlickFactory;

public class GameModelImpl extends StateBasedGame implements GameModel
{
    private static final int INITIAL_STATE_ID = GameState.MAINMENU.ordinal();
    private static final String MUSIC_RESOURCE = "sounds/Pisarz_milosci_midi.ogg";
    
    private Music music;
    
    private Menu menu;
    
    public GameModelImpl(String name)
    {
        super(name);
        this.music = SlickFactory.createMusic(MUSIC_RESOURCE);
    }
    
    public void update(int delta)
    {
        
    }
    
    public void playMusic()
    {
        music.loop();
    }

    public void pauseMusic()
    {
        music.pause();
    }
    
    public Menu getMenu()
    {
        return menu;
    }
    
    public void initMenu()
    {
        this.menu = new Menu();

        MenuField resume = new MenuField(MenuFieldName.RESUME, GraphicPrototypeFactory.createResumeGraphic());
        MenuField singleGame = new MenuField(MenuFieldName.SINGLE_GAME, GraphicPrototypeFactory.createSingleGameGraphic());
        MenuField multiplayer = new MenuField(MenuFieldName.MULTIPLAYER, GraphicPrototypeFactory.createMultiplayerGraphic());
        MenuField exit = new MenuField(MenuFieldName.EXIT, GraphicPrototypeFactory.createExitGraphic());
        MenuFieldPointer menuFieldPointer = new MenuFieldPointer(singleGame, GraphicPrototypeFactory.createMenuFieldPointerGraphic());
        
        float space = singleGame.getGraphic().getHeight();
        
        menuFieldPointer.setSpace(space);
        
        menu.addField(resume, 0);
        menu.setFieldVisibility(0, false);
        menu.addField(singleGame, 1);
        menu.addField(multiplayer, 2);
        menu.addField(exit, 3);
        menu.setFieldPointer(menuFieldPointer);
        menu.setSpace(space);
    }
    
    public void enterState(GameState gameState)
    {
        enterState(gameState.ordinal());
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {
        addState(new MainMenu(this));
        addState(new SingleGame(this));
        addState(new Multiplayer(this));
        
        enterState(INITIAL_STATE_ID);
    }
}
