package paszkiewicz.marcin.model.game.map;

import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import paszkiewicz.marcin.view.graphic.AnimatedGraphicElement;

public class Map extends TiledMap
{
    protected float x = 0;

    protected float y = 0;
    
    protected List<AnimatedGraphicElement> bombs;
    
    protected List<AnimatedGraphicElement> explosions;
    
    protected List<AnimatedGraphicElement> fallingWalls;
    
    protected List<AnimatedGraphicElement> bonuses;
    
    //protected List<Sprite> monsters;
    
    //protected NextStage nextStage;
    
    protected List<List<Boolean>> blockedTiles;
    
    protected List<List<Boolean>> forbiddenTiles;
    
    protected List<List<Boolean>> wallTiles;
    
    public Map(String filename) throws SlickException
    {
        super(filename);
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void draw(Graphics graphics)
    {
        render((int)x, (int)y, getLayerIndex(LayerName.BACKGROUND));
    }

    @Override
    public int getWidth()
    {
        return super.getWidth() * getTileWidth();
    }
    
    @Override
    public int getHeight()
    {
        return super.getHeight() * getTileHeight();
    }
}
