package paszkiewicz.marcin.model;

import paszkiewicz.marcin.component.Menu;

public interface Model
{
    void update(int delta);
    
    void playMusic();
    
    void pauseMusic();
    
    void initMenu();
    
    Menu getMenu();
    
    void enterState(int gameStateId);
}
