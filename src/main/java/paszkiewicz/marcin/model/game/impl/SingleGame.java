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
import paszkiewicz.marcin.component.sprite.Sprite;
import paszkiewicz.marcin.component.sprite.Sprite.SpriteState;
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
import paszkiewicz.marcin.view.graphic.Drawable;

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

        prepareNewStage();
    }

    protected void prepareNewStage()
    {
        this.map = MapFactory.createMap(stageNumber);
        this.player.setAvailableBombs(player.getAllAvailableBombs());
        this.playerToken = player.createToken();
        this.player.setxTile(2);
        this.player.setyTile(1);
    }

    @Override
    public Map getMap()
    {
        return map;
    }

    @Override
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
        draw(getMap().getMonsters(), graphics);
        getPlayer().draw(graphics);
    }

    protected void draw(List<? extends Drawable> drawables, Graphics graphics)
    {
        for (Drawable drawable : drawables)
        {
            drawable.draw(graphics);
        }
    }

    @Override
    public void update(int delta)
    {
        updateAnimations(delta);
        updatePositions(delta);// moveMonsters(delta);
        collectBonus(getPlayer());
        killSpritesIfEnteredExplosion();
        killPlayerIfBumpedOnMonster(getPlayer());
        resetGameIfPlayerIsKilled();
        nextStageIfClear();
    }

    protected void updateAnimations(int delta)
    {
        getMap().getNextStage().updateAnimation(delta);

        updateAnimation(getMap().getBonuses(), delta);
        updateAnimation(getMap().getWalls(), delta);
        updateAnimation(getMap().getMonsters(), delta);

        Iterator<Sprite> iter;
        iter = getMap().getMonsters().iterator();
        while (iter.hasNext())
        {
            Sprite monster = iter.next();

            if (monster.isKilled())
            {
                iter.remove();
            }
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

    protected void updateAnimation(List<? extends AnimatedGraphic> animatedGraphics, int delta)
    {
        for (AnimatedGraphic animatedGraphic : animatedGraphics)
        {
            animatedGraphic.updateAnimation(delta);
        }
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
                    bomb.setAnimationState(AnimationState.ENDED);
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
        updatePosition(getMap().getMonsters(), delta);
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

    protected void updatePosition(List<? extends Sprite> sprites, int delta)
    {
        for (Sprite sprite : sprites)
        {
            updatePosition(sprite, delta);
        }
    }

    protected void updatePosition(Sprite sprite, int delta)
    {
        if (!sprite.isNormal())
        {
            return;
        }

        float speed = sprite.getSpeed();
        float shift;

        collisionDetector.detectCollision(sprite, getMap());

        if (sprite.isMovingDown())
        {
            shift = sprite.getyShift() + delta * speed;
            if (shift > 0.5f)
            {
                shift--;
                sprite.setyTile(sprite.getyTile() + 1);
            }
            sprite.setyShift(shift);
            sprite.setxShift(sprite.getxShift() * 0.92f);
        }
        else if (sprite.isMovingUp())
        {
            shift = sprite.getyShift() - delta * speed;
            if (shift < -0.5f)
            {
                shift++;
                sprite.setyTile(sprite.getyTile() - 1);
            }
            sprite.setyShift(shift);
            sprite.setxShift(sprite.getxShift() * 0.92f);
        }
        else if (sprite.isMovingRight())
        {
            shift = sprite.getxShift() + delta * speed;
            if (shift > 0.5f)
            {
                shift--;
                sprite.setxTile(sprite.getxTile() + 1);
            }
            sprite.setxShift(shift);
            sprite.setyShift(sprite.getyShift() * 0.92f);
        }
        else if (sprite.isMovingLeft())
        {
            shift = sprite.getxShift() - delta * speed;
            if (shift < -0.5f)
            {
                shift++;
                sprite.setxTile(sprite.getxTile() - 1);
            }
            sprite.setxShift(shift);
            sprite.setyShift(sprite.getyShift() * 0.92f);
        }
        else if (!sprite.isMoving())
        {
            sprite.setxShift(sprite.getxShift() * 0.92f);
            sprite.setyShift(sprite.getyShift() * 0.92f);
        }

        float x = (int) (getMap().getX() + (sprite.getxTile() + sprite.getxShift()) * getMap().getTileWidth());
        float y = (int) (getMap().getY() + (sprite.getyTile() + sprite.getyShift()) * getMap().getTileHeight());
        sprite.setX(x);
        sprite.setY(y);
    }

    protected void collectBonus(Player player)
    {
        Iterator<AbstractBonus> iterator;
        iterator = getMap().getBonuses().iterator();
        while (iterator.hasNext())
        {
            AbstractBonus bonus = iterator.next();

            if (collisionDetector.isCollision(player, bonus))
            {
                bonus.modifyFeature(player);
                iterator.remove();
            }
        }
    }

    protected void killSpritesIfEnteredExplosion()
    {
        killSpriteIfEnteredExplosion(player);
        for (Sprite monster : getMap().getMonsters())
        {
            killSpriteIfEnteredExplosion(monster);
        }
    }

    protected void killSpriteIfEnteredExplosion(Sprite sprite)
    {
        if (!sprite.isNormal())
        {
            return;
        }

        for (AnimatedGraphic flame : getMap().getFlames())
        {
            if (collisionDetector.isCollision(sprite, flame))
            {
                sprite.setSpriteState(SpriteState.DYING);
                return;
            }
        }
    }

    protected void killPlayerIfBumpedOnMonster(Player player)
    {
        if (!player.isNormal())
        {
            return;
        }

        for (Sprite monster : getMap().getMonsters())
        {
            if (collisionDetector.isCollision(player, monster))
            {
                player.setSpriteState(SpriteState.DYING);
                return;
            }
        }
    }

    protected void resetGameIfPlayerIsKilled()
    {
        if (!getPlayer().isKilled())
        {
            return;
        }

        getPlayer().setLifes(getPlayer().getLifes() - 1);
        if (getPlayer().isDead())
        {
            gameOver = true;
        }
        else
        {
            resetGame();
        }
    }

    protected void resetGame()
    {
        getPlayer().restoreState(playerToken);
        getPlayer().resetAnimation();
        getPlayer().setSpriteState(SpriteState.NORMAL);
        prepareNewStage();
    }

    protected void nextStageIfClear()
    {
        if (getMap().getMonsters().isEmpty())
        {
            highlightWalls();
            getMap().getNextStage().setAnimationState(AnimationState.ANIMATING);

            if (collisionDetector.isCollision(player, getMap().getNextStage()))
            {
                nextStage();
            }
        }
    }

    protected void highlightWalls()
    {
        for (AnimatedGraphic wall : getMap().getWalls())
        {
            for (AnimatedGraphic bonus : getMap().getBonuses())
            {
                if (collisionDetector.isCollision(wall, bonus))
                {
                    wall.setAnimationState(AnimationState.ANIMATING);
                }
            }

            if (collisionDetector.isCollision(wall, getMap().getNextStage()))
            {
                wall.setAnimationState(AnimationState.ANIMATING);
            }
        }
    }

    protected void nextStage()
    {
        if (++stageNumber > NUMBER_OF_STAGES)
        {
            gameOver = true;
            playerWon = true;
        }
        else
        {
            prepareNewStage();
        }
    }
}
