package paszkiewicz.marcin.view.impl;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;

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

    public void render(Graphics graphics)
    {
        float scale = (float) Display.getHeight() / (float) background.getHeight();
        graphics.scale(scale, scale);
        background.draw(graphics);
    }
}
