package paszkiewicz.marcin.util.factory;

import paszkiewicz.marcin.model.map.Map;

public class MapFactory
{   
    private static final String PATH = "stages/board_stage";
    
    private static final String EXTENSION = ".tmx";
    
    public static Map createMap(int stageNumber)
    {
        return SlickFactory.createMap(PATH + stageNumber + EXTENSION);
    }
}
