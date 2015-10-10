package paszkiewicz.marcin.model.game;

import paszkiewicz.marcin.model.game.map.Map;
import paszkiewicz.marcin.view.graphic.Drawable;
import paszkiewicz.marcin.view.graphic.sprite.Player;

public interface Game extends Drawable
{
    void update(int delta);

    Map getMap();
    
    Player getPlayer();
    
    boolean isGameOver();

    boolean hasPlayerWon();
}
