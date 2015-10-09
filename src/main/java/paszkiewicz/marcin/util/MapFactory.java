package paszkiewicz.marcin.util;

import paszkiewicz.marcin.model.game.map.Map;

public class MapFactory
{   
    private static final String PATH = "stages/board_stage";
    
    private static final String EXTENSION = ".tmx";
    
    public static Map createMap(int stageNumber)
    {
        return SlickFactory.createMap(PATH + stageNumber + EXTENSION);
    }
}
