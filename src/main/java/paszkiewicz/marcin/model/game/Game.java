package paszkiewicz.marcin.model.game;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.model.map.Map;
import paszkiewicz.marcin.view.graphic.Drawable;

public interface Game extends Drawable
{
    void update(int delta);

    Map getMap();
    
    Player getPlayer();
    
    boolean isGameOver();

    boolean hasPlayerWon();
}
