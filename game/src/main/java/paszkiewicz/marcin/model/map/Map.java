package paszkiewicz.marcin.model.map;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Sprite;
import paszkiewicz.marcin.util.Command;
import paszkiewicz.marcin.util.factory.AnimatatedGraphicPrototypeFactory;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;

public class Map extends TiledMap implements paszkiewicz.marcin.model.map.TiledMap
{
    protected float x = 0;

    protected float y = 0;

    protected List<AnimatedGraphic> bombs;

    protected List<AnimatedGraphic> flames;

    protected List<AnimatedGraphic> fallingWalls;

    protected List<AbstractBonus> bonuses;

    protected List<AnimatedGraphic> walls;

    protected List<Sprite> monsters;

    protected AnimatedGraphic nextStage;

    protected boolean blockedTiles[][];

    protected boolean forbiddenTiles[][];

    public Map(String filename) throws SlickException
    {
        super(filename);
        this.bombs = new LinkedList<AnimatedGraphic>();
        this.flames = new LinkedList<AnimatedGraphic>();
        this.fallingWalls = new LinkedList<AnimatedGraphic>();
        this.bonuses = new LinkedList<AbstractBonus>();
        this.walls = new LinkedList<AnimatedGraphic>();
        this.monsters = new LinkedList<Sprite>();

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

    @Override
    public boolean isForbiddenTile(int xTile, int yTile)
    {
        return forbiddenTiles[xTile][yTile];
    }

    @Override
    public boolean isBlockedTile(int xTile, int yTile)
    {
        return blockedTiles[xTile][yTile];
    }

    public List<AnimatedGraphic> getBombs()
    {
        return bombs;
    }

    public List<AnimatedGraphic> getFlames()
    {
        return flames;
    }

    public List<AnimatedGraphic> getFallingWalls()
    {
        return fallingWalls;
    }

    public List<AbstractBonus> getBonuses()
    {
        return bonuses;
    }

    public List<AnimatedGraphic> getWalls()
    {
        return walls;
    }

    public List<Sprite> getMonsters()
    {
        return monsters;
    }

    public AnimatedGraphic getNextStage()
    {
        return nextStage;
    }

    public void destroyWall(int xTile, int yTile)
    {
        for (AnimatedGraphic wall : walls)
        {
            if (wall.getxTile() == xTile && wall.getyTile() == yTile)
            {
                AnimatedGraphic fallingWall = AnimatatedGraphicPrototypeFactory.createFallingWall();
                fallingWall.setxTile(xTile);
                fallingWall.setyTile(yTile);
                fallingWalls.add(fallingWall);

                walls.remove(wall);
                return;
            }
        }
    }

    public void unBlock(int xTile, int yTile)
    {
        blockedTiles[xTile][yTile] = false;
    }

    private void parseMap()
    {
        int tileId;

        for (int i = 0; i < super.getWidth(); i++)
        {
            for (int j = 0; j < super.getHeight(); j++)
            {
                tileId = getTileId(i, j, getLayerIndex(LayerName.BACKGROUND));
                addBackgroundTile(tileId, i, j);

                tileId = getTileId(i, j, getLayerIndex(LayerName.NEXT_STAGE));
                addIfNextStage(tileId, i, j);

                tileId = getTileId(i, j, getLayerIndex(LayerName.BONUSES));
                addIfBonus(tileId, i, j);

                tileId = getTileId(i, j, getLayerIndex(LayerName.WALLS));
                addIfWall(tileId, i, j);

                tileId = getTileId(i, j, getLayerIndex(LayerName.MONSTERS));
                addIfMonster(tileId, i, j);
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
        Command factoryMethod = TileIdToFactoryMethodMapper.map.get(tileId);

        if (factoryMethod != null)
        {
            nextStage = (AnimatedGraphic) factoryMethod.run();
            nextStage.setxTile(i);
            nextStage.setyTile(j);
        }
    }

    private void addIfWall(int tileId, int i, int j)
    {
        Command factoryMethod = TileIdToFactoryMethodMapper.map.get(tileId);

        if (factoryMethod != null)
        {
            AnimatedGraphic wall = (AnimatedGraphic) factoryMethod.run();
            wall.setxTile(i);
            wall.setyTile(j);
            walls.add(wall);
            blockedTiles[i][j] = true;
        }
    }

    private void addIfBonus(int tileId, int i, int j)
    {
        Command factoryMethod = TileIdToFactoryMethodMapper.map.get(tileId);

        if (factoryMethod != null)
        {
            AbstractBonus bonus = (AbstractBonus) factoryMethod.run();
            bonus.setxTile(i);
            bonus.setyTile(j);
            bonuses.add(bonus);
        }
    }

    private void addIfMonster(int tileId, int i, int j)
    {
        Command factoryMethod = TileIdToFactoryMethodMapper.map.get(tileId);

        if (factoryMethod != null)
        {
            Sprite monster = (Sprite) factoryMethod.run();
            monster.setxTile(i);
            monster.setyTile(j);
            monsters.add(monster);
        }
    }
}
