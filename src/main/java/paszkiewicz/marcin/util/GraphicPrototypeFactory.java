package paszkiewicz.marcin.util;

import paszkiewicz.marcin.view.graphic.GraphicElement;

public class GraphicPrototypeFactory
{
    private static GraphicElement mainMenuBackground = new GraphicElement("graphics/background.png");
    
    public static GraphicElement createBackground()
    {
        return mainMenuBackground;
    }
}
