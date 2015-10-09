package paszkiewicz.marcin.view;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.menu.Menu;
import paszkiewicz.marcin.model.game.Game;

public interface View
{
    void drawGame(Game game, Graphics graphics);
    
    void drawMainMenu(Menu menu, Graphics graphics);
}
