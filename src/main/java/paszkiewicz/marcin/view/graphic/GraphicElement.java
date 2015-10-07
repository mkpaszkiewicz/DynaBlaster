package paszkiewicz.marcin.view.graphic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import paszkiewicz.marcin.util.SlickFactory;

public class GraphicElement implements Graphic
{
    protected float x = 0;
    protected float y = 0;
    protected Image image;

    public GraphicElement(Image image)
    {
        setImage(image);
    }

    public GraphicElement(String filename)
    {
        this.image = SlickFactory.createImage(filename);
    }

    public GraphicElement(Image image, float x, float y)
    {
        setImage(image);
        setX(x);
        setY(y);
    }

    public GraphicElement(String filename, float x, float y)
    {
        this.image = SlickFactory.createImage(filename);
        setX(x);
        setY(y);
    }

    public void draw(Graphics graphics)
    {
        graphics.drawImage(image, x, y);
    }

    public GraphicElement clone()
    {
        return new GraphicElement(image, x, y);
    }

    public int getWidth()
    {
        return image.getWidth();
    }

    public int getHeight()
    {
        return image.getHeight();
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}
