package paszkiewicz.marcin.model.game;

import paszkiewicz.marcin.model.game.map.Map;
import paszkiewicz.marcin.view.graphic.Drawable;

public interface Game extends Drawable
{
    void update(int delta);

    Map getMap();

    boolean isGameOver();

    boolean hasPlayerWon();
}
