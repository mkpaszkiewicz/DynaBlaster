package paszkiewicz.marcin.view.graphic;

import org.newdawn.slick.Image;

public interface Graphic extends Drawable
{
    Graphic clone();
    
    int getWidth();

    int getHeight();

    float getX();

    void setX(float x);

    float getY();

    void setY(float y);

    Image getImage();

    void setImage(Image image);
}
