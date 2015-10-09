package paszkiewicz.marcin.core;

import org.newdawn.slick.SlickException;

import paszkiewicz.marcin.model.game.state.GameState;

public interface GameCore
{
    void init() throws SlickException;
    
    void run() throws SlickException;
    
    void exit();
    
    void enterState(GameState gameState);
}
