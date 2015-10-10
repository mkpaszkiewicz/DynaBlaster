package paszkiewicz.marcin.menu;

import paszkiewicz.marcin.view.graphic.Graphic;
import paszkiewicz.marcin.view.graphic.impl.GraphicElement;

public class MenuFieldPointer
{
    private MenuField menuField;
    private Graphic graphic;
    private float space = 0;

    public MenuFieldPointer(MenuField menuField, Graphic graphic)
    {
        this.graphic = graphic;
        this.menuField = menuField;
    }

    public MenuFieldPointer(MenuField menuField, Graphic graphic, float space)
    {
        this.graphic = graphic;
        this.menuField = menuField;
        this.space = space;
    }
    
    public MenuField getCurrentChoice()
    {
        return menuField;
    }

    public void changeChoice(MenuField menuField)
    {
        this.menuField = menuField;
    }
    
    public Graphic getGraphic()
    {
        return graphic;
    }

    public void setGraphic(GraphicElement graphic)
    {
        this.graphic = graphic;
    }

    public float getSpace()
    {
        return space;
    }

    public void setSpace(float space)
    {
        this.space = space;
    }
    
    public void updatePosition()
    {
        Graphic menuFieldGraphic = menuField.getGraphic();

        float x = menuFieldGraphic.getX() - space - graphic.getWidth();
        float y = menuFieldGraphic.getY();

        graphic.setX(x);
        graphic.setY(y);
    }
}
