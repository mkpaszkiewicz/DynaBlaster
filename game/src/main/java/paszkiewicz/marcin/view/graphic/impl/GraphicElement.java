package paszkiewicz.marcin.view.graphic.impl;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import paszkiewicz.marcin.util.factory.SlickFactory;
import paszkiewicz.marcin.view.graphic.Graphic;

public class GraphicElement implements Graphic
{
    protected float x = 0;
    protected float y = 0;
    protected Image image;
    
    public GraphicElement()
    {
    }
    
    public GraphicElement(float x, float y)
    {
        setX(x);
        setY(y);
    }
    
    public GraphicElement(String filename)
    {
        this.image = SlickFactory.createImage(filename);
    }
    
    public GraphicElement(Image image)
    {
        setImage(image);
    }
    
    public GraphicElement(String filename, float x, float y)
    {
        this.image = SlickFactory.createImage(filename);
        setX(x);
        setY(y);
    }

    public GraphicElement(Image image, float x, float y)
    {
        setImage(image);
        setX(x);
        setY(y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.drawImage(image, x, y);
    }
    
    @Override
    public GraphicElement clone()
    {
        return new GraphicElement(image, x, y);
    }
    
    @Override
    public int getWidth()
    {
        return image.getWidth();
    }

    @Override
    public int getHeight()
    {
        return image.getHeight();
    }
    
    @Override
    public float getX()
    {
        return x;
    }
    
    @Override
    public void setX(float x)
    {
        this.x = x;
    }
    
    @Override
    public float getY()
    {
        return y;
    }
    
    @Override
    public void setY(float y)
    {
        this.y = y;
    }
    
    @Override
    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}
