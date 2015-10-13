package paszkiewicz.marcin.model;

import paszkiewicz.marcin.model.game.Game;

public interface Model extends MenuModel
{
    void update(int delta);

    void enterState(int gameStateId);

    void startNewGame(Game game);
    
    Game getGame();
    
    void playMusic();
    
    void resumeMusic();
    
    void pauseMusic();
    
    boolean isMusicPaused();
}
