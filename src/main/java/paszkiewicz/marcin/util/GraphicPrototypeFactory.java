package paszkiewicz.marcin.util;

import paszkiewicz.marcin.view.graphic.GraphicElement;

public class GraphicPrototypeFactory
{
    private static GraphicElement mainMenuBackground = new GraphicElement("graphics/background.png");

    private static GraphicElement resumeGraphic = new GraphicElement("graphics/menu/resume.png");

    private static GraphicElement singleGameGraphic = new GraphicElement("graphics/menu/single_game.png");

    private static GraphicElement multiplayerGraphic = new GraphicElement("graphics/menu/multiplayer.png");

    private static GraphicElement exitGraphic = new GraphicElement("graphics/menu/exit.png");

    private static GraphicElement menuFieldPointerGraphic = new GraphicElement("graphics/menu/field_pointer.png");

    public static GraphicElement createBackground()
    {
        return mainMenuBackground.clone();
    }
    
    public static GraphicElement createResumeGraphic()
    {
        return resumeGraphic.clone();
    }
    
    public static GraphicElement createSingleGameGraphic()
    {
        return singleGameGraphic.clone();
    }

    public static GraphicElement createMultiplayerGraphic()
    {
        return multiplayerGraphic.clone();
    }
    
    public static GraphicElement createExitGraphic()
    {
        return exitGraphic.clone();
    }
    
    public static GraphicElement createMenuFieldPointerGraphic()
    {
        return menuFieldPointerGraphic.clone();
    }
}
