package paszkiewicz.marcin.view.impl;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.Menu;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.util.GraphicPrototypeFactory;
import paszkiewicz.marcin.view.View;
import paszkiewicz.marcin.view.graphic.GraphicElement;

public class MainMenuView implements View
{
    private GraphicElement background;

    public MainMenuView()
    {
        this.background = GraphicPrototypeFactory.createBackground();
    }

    public void render(Model model, Graphics graphics)
    {
        float scale = (float) Display.getHeight() / (float) background.getHeight();
        graphics.scale(scale, scale);
        
        background.draw(graphics);
        
        Menu menu = model.getMenu();
        menu.setX(background.getX() + background.getWidth()/2 - menu.getWidth()/2);
        menu.setY(background.getY() + background.getHeight()/2 + menu.getSpace()*2);
        
        menu.draw(graphics);
    }
}
