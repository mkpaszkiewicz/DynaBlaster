package paszkiewicz.marcin.menu;

import paszkiewicz.marcin.view.graphic.GraphicElement;

public class MenuField
{
    private String name;
    private GraphicElement graphic;
    private boolean visibility = true;

    public MenuField(String name, GraphicElement graphic)
    {
        this.name = name;
        this.graphic = graphic;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public GraphicElement getGraphic()
    {
        return graphic;
    }
    
    public void setGraphic(GraphicElement graphic)
    {
        this.graphic = graphic;
    }
    
    public boolean isVisible()
    {
        return visibility;
    }

    public void setVisibility(boolean visibility)
    {
        this.visibility = visibility;
    }
}
