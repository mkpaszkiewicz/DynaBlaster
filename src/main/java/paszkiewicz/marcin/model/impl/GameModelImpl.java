package paszkiewicz.marcin.model.impl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import paszkiewicz.marcin.model.GameModel;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.model.game.state.MainMenu;
import paszkiewicz.marcin.model.game.state.Multiplayer;
import paszkiewicz.marcin.model.game.state.SingleGame;
import paszkiewicz.marcin.util.SlickFactory;

public class GameModelImpl extends StateBasedGame implements GameModel
{
    private static final int INITIAL_STATE_ID = GameState.MAINMENU.ordinal();
    
    private Music music;
    
    public GameModelImpl(String name)
    {
        super(name);

        this.music = SlickFactory.createMusic("sounds/Pisarz_milosci_midi.ogg");
    }
    
    public void playMusic()
    {
        music.loop();
        
    }

    public void pauseMusic()
    {
        music.pause();
    }
    
    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {
        addState(new MainMenu());
        addState(new SingleGame());
        addState(new Multiplayer());
        
        enterState(INITIAL_STATE_ID);
    }
}
