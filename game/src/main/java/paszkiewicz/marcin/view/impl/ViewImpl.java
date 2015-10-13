package paszkiewicz.marcin.view.impl;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.menu.Menu;
import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.map.Map;
import paszkiewicz.marcin.util.factory.GraphicPrototypeFactory;
import paszkiewicz.marcin.view.View;
import paszkiewicz.marcin.view.graphic.Graphic;

public class ViewImpl implements View
{   
    protected Graphic gameOver = GraphicPrototypeFactory.createGameOverGraphic();
    
    protected Graphic playerWon = GraphicPrototypeFactory.createPlayerWonGraphic();
    
    @Override
    public void draw(Game game, Graphics graphics)
    {
        Map map = game.getMap();
        float scale = (float) (Display.getHeight()) / map.getHeight();
        graphics.scale(scale, scale);

        float x = (float) ((Display.getWidth() / 2.0 - map.getWidth() * scale / 2.0) / scale);
        float y = 0;
        map.setX(x);
        map.setY(y);

        game.draw(graphics);
        if (game.isGameOver())
        {
            if(game.hasPlayerWon())
            {
                x = map.getX() + map.getWidth() / 2 - playerWon.getWidth() / 2;
                y = map.getY() + map.getHeight() / 2 - playerWon.getHeight() / 2;
                playerWon.setX(x);
                playerWon.setY(y);
                playerWon.draw(graphics);
            }
            else
            {
                x = map.getX() + map.getWidth() / 2 - gameOver.getWidth() / 2;
                y = map.getY() + map.getHeight() / 2 - gameOver.getHeight() / 2;
                gameOver.setX(x);
                gameOver.setY(y);
                gameOver.draw(graphics);
            }
        }
    }

    @Override
    public void draw(Menu menu, Graphics graphics)
    {
        Graphic background = menu.getBackground();

        float scale = (float) Display.getHeight() / (float) background.getHeight();
        graphics.scale(scale, scale);

        float x = (float) (Display.getWidth() / 2.0 - background.getWidth() * scale / 2.0) / scale;
        float y = (float) (Display.getHeight() / 2.0 - background.getHeight() * scale / 2.0) / scale;
        background.setX(x);
        background.setY(y);

        x = background.getX() + background.getWidth() / 2 - menu.getWidth() / 2;
        y = background.getY() + background.getHeight() / 2 + menu.getSpace() * 2;
        menu.setX(x);
        menu.setY(y);

        menu.draw(graphics);
    }
}
