package paszkiewicz.marcin.model.game.impl;

import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.component.sprite.PlayerToken;
import paszkiewicz.marcin.model.CollisionDetector;
import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.impl.CollisionDetectorImpl;
import paszkiewicz.marcin.model.map.LayerName;
import paszkiewicz.marcin.model.map.Map;
import paszkiewicz.marcin.util.factory.AnimatatedGraphicPrototypeFactory;
import paszkiewicz.marcin.util.factory.ExplosionFactory;
import paszkiewicz.marcin.util.factory.MapFactory;
import paszkiewicz.marcin.util.factory.SpriteFactory;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;

public class SingleGame implements Game
{
    protected static int NUMBER_OF_STAGES = 10;

    protected int stageNumber = 1;

    protected Map map;

    protected Player player;

    protected PlayerToken playerToken;

    protected CollisionDetector collisionDetector;

    protected boolean gameOver = false;

    protected boolean playerWon = false;

    public SingleGame()
    {
        this.collisionDetector = new CollisionDetectorImpl();
        this.player = SpriteFactory.createPlayer();

        prepareStage();
    }

    protected void prepareStage()
    {
        this.map = MapFactory.createMap(stageNumber);
        this.playerToken = player.createToken();
        this.player.setxTile(2);
        this.player.setyTile(1);
    }

    @Override
    public Map getMap()
    {
        return map;
    }

    public Player getPlayer()
    {
        return player;
    }

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

    @Override
    public void plantBomb(Player player)
    {
        if (!player.hasBomb() || isGameOver())
        {
            return;
        }

        player.setAvailableBombs(player.getAvailableBombs() - 1);

        Bomb bomb = (Bomb) AnimatatedGraphicPrototypeFactory.createBomb();
        bomb.setOwner(player);
        bomb.setxTile(player.getxTile());
        bomb.setyTile(player.getyTile());

        map.getBombs().add(bomb);
    }

    @Override
    public void draw(Graphics graphics)
    {
        map.render((int) map.getX(), (int) map.getY(), map.getLayerIndex(LayerName.BACKGROUND));
        map.getNextStage().draw(graphics);
        draw(map.getBonuses(), graphics);
        draw(map.getWalls(), graphics);
        draw(map.getFallingWalls(), graphics);
        draw(map.getBombs(), graphics);
        draw(map.getFlames(), graphics);
        player.draw(graphics);
    }
    
    protected void draw(List<? extends AnimatedGraphic> animatedGraphics, Graphics graphics)
    {
        for (AnimatedGraphic animatedGraphic : animatedGraphics)
        {
            animatedGraphic.draw(graphics);
        }
    }
    
    @Override
    public void update(int delta)
    {
        updateAnimations(delta);
        updatePositions(delta);
    }

    protected void updateAnimations(int delta)
    {
        Iterator<AnimatedGraphic> iterator;
        map.getNextStage().updateAnimation(delta);

        for (AnimatedGraphic bonus : map.getBonuses())
        {
            bonus.updateAnimation(delta);
        }

        for (AnimatedGraphic wall : map.getWalls())
        {
            wall.updateAnimation(delta);
        }

        iterator = map.getBombs().iterator();
        while (iterator.hasNext())
        {
            AnimatedGraphic bomb = iterator.next();

            bomb.updateAnimation(delta);

            if (bomb.isAnimationEnded())
            {
                Player bombOwner = ((Bomb) bomb).getOwner();
                bombOwner.setAvailableBombs(bombOwner.getAvailableBombs() + 1);
                iterator.remove();
                explode((Bomb) bomb);
            }
        }
        
        iterator = map.getFlames().iterator();
        while (iterator.hasNext())
        {
            AnimatedGraphic flame = iterator.next();

            flame.updateAnimation(delta);

            if (flame.isAnimationEnded())
            {
                iterator.remove();
            }
        }
        
        iterator = map.getFallingWalls().iterator();
        while (iterator.hasNext())
        {
            AnimatedGraphic fallingWall = iterator.next();

            fallingWall.updateAnimation(delta);
            
            if (fallingWall.isAnimationEnded())
            {
                map.unBlock(fallingWall.getxTile(), fallingWall.getyTile());
                iterator.remove();
            }
        }
        
        player.updateAnimation(delta);
    }

    protected void explode(Bomb bomb)
    {
        List<AnimatedGraphic> flames = ExplosionFactory.createExplosion(bomb, map);
        map.getFlames().addAll(flames);
    }

    protected void updatePositions(int delta)
    {
        updatePosition(map.getNextStage());
        updatePosition(map.getBonuses());
        updatePosition(map.getWalls());
        updatePosition(map.getFallingWalls());
        updatePosition(map.getBombs());
        updatePosition(map.getFlames());
        updatePosition(player, delta);
    }
    
    protected void updatePosition(List<? extends AnimatedGraphic> animatedGraphics)
    {
        for (AnimatedGraphic animatedGraphic : animatedGraphics)
        {
            updatePosition(animatedGraphic);
        }
    }
    
    protected void updatePosition(AnimatedGraphic animatedGraphic)
    {
        float x = (int) (map.getX() + animatedGraphic.getxTile() * map.getTileWidth());
        float y = (int) (map.getY() + animatedGraphic.getyTile() * map.getTileHeight());
        animatedGraphic.setX(x);
        animatedGraphic.setY(y);
    }
    
    protected void updatePosition(List<? extends DynamicGraphic> dynamicGraphics, int delta)
    {
        for (DynamicGraphic dynamicGraphic : dynamicGraphics)
        {
            updatePosition(dynamicGraphic, delta);
        }
    }
    
    protected void updatePosition(DynamicGraphic dynamicGraphic, int delta)
    {
        float speed = dynamicGraphic.getSpeed();
        float shift;

        collisionDetector.detectCollision(dynamicGraphic, map);

        if (dynamicGraphic.isMovingDown())
        {
            shift = dynamicGraphic.getyShift() + delta * speed;
            if (shift > 0.5f)
            {
                shift--;
                dynamicGraphic.setyTile(dynamicGraphic.getyTile() + 1);
            }
            dynamicGraphic.setyShift(shift);
            dynamicGraphic.setxShift(dynamicGraphic.getxShift() * 0.92f);
        }
        else if (dynamicGraphic.isMovingUp())
        {
            shift = dynamicGraphic.getyShift() - delta * speed;
            if (shift < -0.5f)
            {
                shift++;
                dynamicGraphic.setyTile(dynamicGraphic.getyTile() - 1);
            }
            dynamicGraphic.setyShift(shift);
            dynamicGraphic.setxShift(dynamicGraphic.getxShift() * 0.92f);
        }
        else if (dynamicGraphic.isMovingRight())
        {
            shift = dynamicGraphic.getxShift() + delta * speed;
            if (shift > 0.5f)
            {
                shift--;
                dynamicGraphic.setxTile(dynamicGraphic.getxTile() + 1);
            }
            dynamicGraphic.setxShift(shift);
            dynamicGraphic.setyShift(dynamicGraphic.getyShift() * 0.92f);
        }
        else if (dynamicGraphic.isMovingLeft())
        {
            shift = dynamicGraphic.getxShift() - delta * speed;
            if (shift < -0.5f)
            {
                shift++;
                dynamicGraphic.setxTile(dynamicGraphic.getxTile() - 1);
            }
            dynamicGraphic.setxShift(shift);
            dynamicGraphic.setyShift(dynamicGraphic.getyShift() * 0.92f);
        }
        else if (!dynamicGraphic.isMoving())
        {
            dynamicGraphic.setxShift(dynamicGraphic.getxShift() * 0.92f);
            dynamicGraphic.setyShift(dynamicGraphic.getyShift() * 0.92f);
        }

        float x = (int) (map.getX() + (dynamicGraphic.getxTile() + dynamicGraphic.getxShift()) * map.getTileWidth());
        float y = (int) (map.getY() + (dynamicGraphic.getyTile() + dynamicGraphic.getyShift()) * map.getTileHeight());
        dynamicGraphic.setX(x);
        dynamicGraphic.setY(y);
    }
}
