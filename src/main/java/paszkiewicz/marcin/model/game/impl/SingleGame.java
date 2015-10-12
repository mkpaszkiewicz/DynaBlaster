package paszkiewicz.marcin.model.game.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.component.Flame;
import paszkiewicz.marcin.component.bonus.AbstractBonus;
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
import paszkiewicz.marcin.view.graphic.AnimatedGraphic.AnimationState;
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

        getMap().getBombs().add(bomb);
    }

    @Override
    public void draw(Graphics graphics)
    {
        getMap().render((int) getMap().getX(), (int) getMap().getY(), getMap().getLayerIndex(LayerName.BACKGROUND));
        getMap().getNextStage().draw(graphics);
        draw(getMap().getBonuses(), graphics);
        draw(getMap().getWalls(), graphics);
        draw(getMap().getFallingWalls(), graphics);
        draw(getMap().getBombs(), graphics);
        draw(getMap().getFlames(), graphics);
        getPlayer().draw(graphics);
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
        collectBonus();
    }

    protected void updateAnimations(int delta)
    {
        getMap().getNextStage().updateAnimation(delta);

        for (AnimatedGraphic bonus : getMap().getBonuses())
        {
            bonus.updateAnimation(delta);
        }

        for (AnimatedGraphic wall : getMap().getWalls())
        {
            wall.updateAnimation(delta);
        }

        Iterator<AnimatedGraphic> iterator;
        iterator = getMap().getBombs().iterator();
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

        iterator = getMap().getFlames().iterator();
        while (iterator.hasNext())
        {
            AnimatedGraphic flame = iterator.next();

            flame.updateAnimation(delta);

            if (flame.isAnimationEnded())
            {
                iterator.remove();
            }
        }

        iterator = getMap().getFallingWalls().iterator();
        while (iterator.hasNext())
        {
            AnimatedGraphic fallingWall = iterator.next();

            fallingWall.updateAnimation(delta);

            if (fallingWall.isAnimationEnded())
            {
                getMap().unBlock(fallingWall.getxTile(), fallingWall.getyTile());
                iterator.remove();
            }
        }

        getPlayer().updateAnimation(delta);
    }

    protected void explode(Bomb bomb)
    {
        List<AnimatedGraphic> flames = ExplosionFactory.createExplosion(bomb, getMap());
        getMap().getFlames().addAll(flames);
        explodeBombsIfOverlapFlame();
        deleteFlamesWithLowerPriority();
    }

    protected void explodeBombsIfOverlapFlame()
    {
        for (AnimatedGraphic bomb : getMap().getBombs())
        {
            for (AnimatedGraphic flame : getMap().getFlames())
            {
                if (collisionDetector.isCollision(bomb, flame))
                {
                    bomb.setState(AnimationState.ENDED);
                    break;
                }
            }
        }
    }

    protected void deleteFlamesWithLowerPriority()
    {
        List<AnimatedGraphic> tempFlames = new LinkedList<AnimatedGraphic>(map.getFlames());

        for (AnimatedGraphic flame1 : tempFlames)
        {
            for (AnimatedGraphic flame2 : tempFlames)
            {
                if (collisionDetector.isCollision(flame1, flame2) && ((Flame) flame1).hasHigherPriority((Flame) flame2))
                {
                    getMap().getFlames().remove(flame2);
                }
            }
        }
    }

    protected void updatePositions(int delta)
    {
        updatePosition(getMap().getNextStage());
        updatePosition(getMap().getBonuses());
        updatePosition(getMap().getWalls());
        updatePosition(getMap().getFallingWalls());
        updatePosition(getMap().getBombs());
        updatePosition(getMap().getFlames());
        updatePosition(getPlayer(), delta);
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
        float x = (int) (getMap().getX() + animatedGraphic.getxTile() * getMap().getTileWidth());
        float y = (int) (getMap().getY() + animatedGraphic.getyTile() * getMap().getTileHeight());
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

        collisionDetector.detectCollision(dynamicGraphic, getMap());

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

        float x = (int) (getMap().getX() + (dynamicGraphic.getxTile() + dynamicGraphic.getxShift()) * getMap().getTileWidth());
        float y = (int) (getMap().getY() + (dynamicGraphic.getyTile() + dynamicGraphic.getyShift()) * getMap().getTileHeight());
        dynamicGraphic.setX(x);
        dynamicGraphic.setY(y);
    }

    protected void collectBonus()
    {
        Iterator<AbstractBonus> iterator;
        iterator = getMap().getBonuses().iterator();
        while (iterator.hasNext())
        {
            AbstractBonus bonus = iterator.next();

            if (collisionDetector.isCollision(getPlayer(), bonus))
            {
                bonus.modifyFeature(getPlayer());
                iterator.remove();
            }
        }
    }
}
