package paszkiewicz.marcin.model.game.impl;

import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.game.map.Map;
import paszkiewicz.marcin.util.MapFactory;

public class SingleGame implements Game
{
    protected static int NUMBER_OF_STAGES = 10;

    protected int stageNumber;

    protected Map map;

    // protected Player player;

    protected boolean gameOver;

    protected boolean playerWon;

    public SingleGame()
    {
        this.stageNumber = 1;
        this.map = MapFactory.createMap(stageNumber);
    }

    @Override
    public void update(int delta)
    {

    }

    public Map getMap()
    {
        return map;
    }

    // public Player getPlayer()
    // {
    // return player;
    // }

    public boolean isGameOver()
    {
        return gameOver;
    }

    public boolean hasPlayerWon()
    {
        return playerWon;
    }
}
