package paszkiewicz.marcin.model.game;

import paszkiewicz.marcin.model.game.map.Map;
import paszkiewicz.marcin.util.GameObjectVisitor;
import paszkiewicz.marcin.view.graphic.Drawable;

public interface Game extends Drawable, GameObjectVisitor
{
    void update(int delta);
    
    Map getMap();
    
    boolean isGameOver();
    
    boolean hasPlayerWon();
}
