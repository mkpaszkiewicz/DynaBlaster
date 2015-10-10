package paszkiewicz.marcin.view;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.menu.Menu;
import paszkiewicz.marcin.model.game.Game;

public interface View
{
    void draw(Game game, Graphics graphics);
    
    void draw(Menu menu, Graphics graphics);
}
