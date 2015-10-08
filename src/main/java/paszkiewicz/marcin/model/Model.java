package paszkiewicz.marcin.model;

import paszkiewicz.marcin.component.Menu;
import paszkiewicz.marcin.model.game.state.GameState;

public interface Model
{
    void update(int delta);
    
    void playMusic();
    
    void pauseMusic();
    
    void initMenu();
    
    Menu getMenu();
    
    void enterState(GameState gameState);
}
