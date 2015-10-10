package paszkiewicz.marcin.menu;

import paszkiewicz.marcin.view.graphic.Graphic;

public class MenuField
{
    private String name;
    private Graphic graphic;
    private boolean visibility = true;

    public MenuField(String name, Graphic graphic)
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
    
    public Graphic getGraphic()
    {
        return graphic;
    }
    
    public void setGraphic(Graphic graphic)
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
