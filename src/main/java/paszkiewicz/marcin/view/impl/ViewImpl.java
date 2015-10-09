package paszkiewicz.marcin.view.impl;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.menu.Menu;
import paszkiewicz.marcin.menu.MenuField;
import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.game.map.Map;
import paszkiewicz.marcin.util.GraphicPrototypeFactory;
import paszkiewicz.marcin.view.View;
import paszkiewicz.marcin.view.graphic.GraphicElement;

public class ViewImpl implements View
{
    protected GraphicElement background;
    
    public ViewImpl()
    {
        this.background = GraphicPrototypeFactory.createBackground();
    }
    
    @Override
    public void drawGame(Game game, Graphics graphics)
    {   
        Map map = game.getMap();
        float scale = (float)(Display.getHeight()) / map.getHeight();
        graphics.scale(scale, scale);
        
        float x = (float)((Display.getWidth() / 2.0 - map.getWidth() * scale / 2.0) / scale);
        float y = 0;
        
        map.setX(x);
        map.setY(y);
        
        game.getMap().draw(graphics);
    }
    
    @Override
    public void drawMainMenu(Menu menu, Graphics graphics)
    {
        float scale = (float) Display.getHeight() / (float) background.getHeight();
        graphics.scale(scale, scale);
        
        float x = (float) (Display.getWidth() / 2.0 - background.getWidth() * scale / 2.0) / scale;
        float y = (float) (Display.getHeight() / 2.0 - background.getHeight() * scale / 2.0) / scale;
        background.setX(x);
        background.setY(y);
        background.draw(graphics);
        
        x = background.getX() + background.getWidth()/2 - menu.getWidth()/2;
        y = background.getY() + background.getHeight()/2 + menu.getSpace()*2;
        menu.setX(x);
        menu.setY(y);
        drawMenu(menu, graphics);
    }
    
    protected void drawMenu(Menu menu, Graphics graphics)
    {
        for (MenuField field : menu.getFields())
        {
            if (field.isVisible())
            {
                field.getGraphic().draw(graphics);
            }
        }

        if (menu.getFieldPointer() != null)
        {
            menu.getFieldPointer().getGraphic().draw(graphics);
        }
    }
}
