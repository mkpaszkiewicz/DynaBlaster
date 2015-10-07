package paszkiewicz.marcin.view.graphic;

import org.newdawn.slick.Graphics;

public interface Graphic
{
    public void draw(Graphics graphics);
    
    public Graphic clone();
}
