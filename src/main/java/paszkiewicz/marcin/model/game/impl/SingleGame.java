package paszkiewicz.marcin.model.game.impl;

import java.util.List;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.model.game.AnimatedGameObject;
import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.game.map.LayerName;
import paszkiewicz.marcin.model.game.map.Map;
import paszkiewicz.marcin.util.MapFactory;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.bonus.Bonus;

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
    public void draw(Graphics graphics)
    {
        map.render((int) map.getX(), (int) map.getY(), map.getLayerIndex(LayerName.BACKGROUND));
        map.getNextStage().draw(graphics);
        for (AnimatedGraphic wall : map.getWalls())
        {
            wall.draw(graphics);
        }
        // render((int) x, (int) y, getLayerIndex(LayerName.WALLS));
        // draw(map.getBonuses(), graphics);

    }

    @Override
    public void update(int delta)
    {
        updatePositions(delta);
        updateAnimations(delta);
    }

    @Override
    public Map getMap()
    {
        return map;
    }

    // public Player getPlayer()
    // {
    // return player;
    // }

    @Override
    public boolean isGameOver()
    {
        return gameOver;
    }

    @Override
    public boolean hasPlayerWon()
    {
        return playerWon;
    }

    protected void updateAnimations(int delta)
    {
        map.getNextStage().updateAnimation(delta);

        for (AnimatedGraphic wall : map.getWalls())
        {
            wall.updateAnimation(delta);
        }
    }
    
    protected void updatePositions(int delta)
    {
        updatePosition(map.getNextStage());

        for (AnimatedGraphic wall : map.getWalls())
        {
            updatePosition(wall);
        }
    }
    
    protected void updatePosition(AnimatedGraphic animatedGraphic)
    {
        float x = (int) (map.getX() + animatedGraphic.getxTile() * map.getTileWidth());
        float y = (int) (map.getY() + animatedGraphic.getyTile() * map.getTileHeight());
        animatedGraphic.setX(x);
        animatedGraphic.setY(y);
    }
    
    protected void draw(List<AnimatedGameObject> animatedGameObjects, Graphics graphics)
    {
        for (AnimatedGameObject animatedGameObject : animatedGameObjects)
        {
            if (animatedGameObject.isAnimationEnded())
            {
                animatedGameObject.applyVisitor(this);
                animatedGameObjects.remove(animatedGameObject);
            }
            else
            {
                animatedGameObject.draw(graphics);
            }
        }
    }

    @Override
    public void visit(Bonus bonus)
    {
    }
}
