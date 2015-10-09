package paszkiewicz.marcin.model.game;

import paszkiewicz.marcin.model.game.map.Map;

public interface Game
{
    void update(int delta);
    
    Map getMap();
}
