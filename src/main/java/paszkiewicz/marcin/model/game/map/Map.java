package paszkiewicz.marcin.model.game.map;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import paszkiewicz.marcin.util.AnimatatedGraphicPrototypeFactory;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;

public class Map extends TiledMap
{
    protected float x = 0;

    protected float y = 0;

    protected List<AnimatedGraphic> bombs;

    protected List<AnimatedGraphic> explosions;

    protected List<AnimatedGraphic> fallingWalls;

    protected List<AnimatedGraphic> bonuses;

    protected List<AnimatedGraphic> walls;
    
    // protected List<Sprite> monsters;

    protected AnimatedGraphic nextStage;

    protected boolean blockedTiles[][];

    protected boolean forbiddenTiles[][];

    public Map(String filename) throws SlickException
    {
        super(filename);
        this.bombs = new LinkedList<AnimatedGraphic>();
        this.explosions = new LinkedList<AnimatedGraphic>();
        this.fallingWalls = new LinkedList<AnimatedGraphic>();
        this.bonuses = new LinkedList<AnimatedGraphic>();
        this.walls = new LinkedList<AnimatedGraphic>();
        
        this.blockedTiles = new boolean[super.getWidth()][super.getHeight()];
        this.forbiddenTiles = new boolean[super.getWidth()][super.getHeight()];

        parseMap();
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
    
    public boolean isForbiddenTile(int xTile, int yTile)
    {
        return forbiddenTiles[xTile][yTile];
    }
    
    public boolean isBlockedTile(int xTile, int yTile)
    {
        return blockedTiles[xTile][yTile];
    }
    
    public List<AnimatedGraphic> getBombs()
    {
        return bombs;
    }

    public List<AnimatedGraphic> getExplosions()
    {
        return explosions;
    }

    public List<AnimatedGraphic> getFallingWalls()
    {
        return fallingWalls;
    }

    public List<AnimatedGraphic> getBonuses()
    {
        return bonuses;
    }
    
    public List<AnimatedGraphic> getWalls()
    {
        return walls;
    }
    
    public AnimatedGraphic getNextStage()
    {
        return nextStage;
    }
    
    private void parseMap()
    {
        int id;

        for (int i = 0; i < super.getWidth(); i++)
        {
            for (int j = 0; j < super.getHeight(); j++)
            {
                id = getTileId(i, j, getLayerIndex(LayerName.BACKGROUND));
                addBackgroundTile(id, i, j);

                id = getTileId(i, j, getLayerIndex(LayerName.NEXT_STAGE));
                addIfNextStage(id, i, j);

                id = getTileId(i, j, getLayerIndex(LayerName.BONUSES));
                addIfBonus(id, i, j);

                id = getTileId(i, j, getLayerIndex(LayerName.WALLS));
                addIfWall(id, i, j);

                id = getTileId(i, j, getLayerIndex(LayerName.MONSTERS));
                addIfMonster(id, i, j);
            }
        }
    }

    private void addBackgroundTile(int tileId, int i, int j)
    {
        String value = getTileProperty(tileId, "blocked", "false");
        if (value.equals("true"))
        {
            forbiddenTiles[i][j] = true;
            blockedTiles[i][j] = true;
        }
    }

    private void addIfNextStage(int tileId, int i, int j)
    {
        if (tileId == TileId.NEXT_STAGE)
        {
            nextStage = AnimatatedGraphicPrototypeFactory.createNextStage();
            nextStage.setxTile(i);
            nextStage.setyTile(j);
        }
    }

    private void addIfBonus(int tileId, int i, int j)
    {
        // TODO Auto-generated method stub

    }

    private void addIfWall(int tileId, int i, int j)
    {
        if (tileId == TileId.WALL)
        {
            AnimatedGraphic wall = AnimatatedGraphicPrototypeFactory.createWall();
            wall.setxTile(i);
            wall.setyTile(j);
            walls.add(wall);
            blockedTiles[i][j] = true;
        }
    }

    private void addIfMonster(int tileId, int i, int j)
    {
        // TODO Auto-generated method stub

    }
}
