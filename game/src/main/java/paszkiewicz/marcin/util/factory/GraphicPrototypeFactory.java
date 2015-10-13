package paszkiewicz.marcin.util.factory;

import paszkiewicz.marcin.view.graphic.Graphic;
import paszkiewicz.marcin.view.graphic.impl.GraphicElement;

public class GraphicPrototypeFactory
{
    private static Graphic gameOverGraphic = new GraphicElement("graphics/game_over.png");
    
    private static Graphic playerWonGraphic = new GraphicElement("graphics/you_win.png");
    
    private static Graphic mainMenuBackground = new GraphicElement("graphics/background.png");

    private static Graphic resumeGraphic = new GraphicElement("graphics/menu/resume.png");

    private static Graphic singleGameGraphic = new GraphicElement("graphics/menu/single_game.png");

    private static Graphic multiplayerGraphic = new GraphicElement("graphics/menu/multiplayer.png");

    private static Graphic exitGraphic = new GraphicElement("graphics/menu/exit.png");

    private static Graphic menuFieldPointerGraphic = new GraphicElement("graphics/menu/field_pointer.png");
    
    public static Graphic createGameOverGraphic()
    {
        return gameOverGraphic.clone();
    }
    
    public static Graphic createBackground()
    {
        return mainMenuBackground.clone();
    }
    
    public static Graphic createPlayerWonGraphic()
    {
        return playerWonGraphic.clone();
    }
    
    public static Graphic createResumeGraphic()
    {
        return resumeGraphic.clone();
    }
    
    public static Graphic createSingleGameGraphic()
    {
        return singleGameGraphic.clone();
    }

    public static Graphic createMultiplayerGraphic()
    {
        return multiplayerGraphic.clone();
    }
    
    public static Graphic createExitGraphic()
    {
        return exitGraphic.clone();
    }
    
    public static Graphic createMenuFieldPointerGraphic()
    {
        return menuFieldPointerGraphic.clone();
    }
}
