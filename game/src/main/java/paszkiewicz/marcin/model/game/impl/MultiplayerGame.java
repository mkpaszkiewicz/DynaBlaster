package paszkiewicz.marcin.model.game.impl;

import java.util.Iterator;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.model.map.LayerName;
import paszkiewicz.marcin.util.factory.MapFactory;
import paszkiewicz.marcin.util.factory.SpriteFactory;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;

public class MultiplayerGame extends SingleGame
{
    private static int STARTING_BOMBS = 2;

    private static int STARTING_RANGE = 2;

    private static int STARTING_LIFES = 1;

    protected Player opponent;

    protected boolean gameStarted = false;

    public MultiplayerGame()
    {
        super();
    }

    public Player getOpponent()
    {
        return opponent;
    }

    public void setStartingPositions(String string)
    {
        setGameStarted(true);
        if (string.equals("top left"))
        {
            player.setxTile(2);
            player.setyTile(1);
            opponent.setxTile(14);
            opponent.setyTile(11);
        }
        else
        {
            opponent.setxTile(2);
            opponent.setyTile(1);
            player.setxTile(14);
            player.setyTile(11);
        }
    }

    public boolean isGameStarted()
    {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted)
    {
        this.gameStarted = gameStarted;
    }

    @Override
    protected void prepareNewStage()
    {
        this.player = SpriteFactory.createPlayer();
        this.opponent = SpriteFactory.createOpponent();
        this.map = MapFactory.createMap(0);
        getOpponent().setAvailableBombs(STARTING_BOMBS);
        getOpponent().setBombRange(STARTING_RANGE);
        getOpponent().setLifes(STARTING_LIFES);
        getPlayer().setAvailableBombs(STARTING_BOMBS);
        getPlayer().setBombRange(STARTING_RANGE);
        getPlayer().setLifes(STARTING_LIFES);
    }

    @Override
    public void draw(Graphics graphics)
    {
        getMap().render((int) getMap().getX(), (int) getMap().getY(), getMap().getLayerIndex(LayerName.BACKGROUND));
        draw(getMap().getBonuses(), graphics);
        draw(getMap().getWalls(), graphics);
        draw(getMap().getFallingWalls(), graphics);
        draw(getMap().getBombs(), graphics);
        draw(getMap().getFlames(), graphics);
        if(isGameStarted())
        {
            getPlayer().draw(graphics);
            getOpponent().draw(graphics);
        }
    }

    @Override
    public void update(int delta)
    {
        collectBonus(getPlayer());
        collectBonus(getOpponent());
        killSpriteIfEnteredExplosion(getPlayer());
        killSpriteIfEnteredExplosion(getOpponent());
        endGameIfPlayerIsKilled();
        updateAnimations(delta);
        updatePositions(delta);
    }

    protected void endGameIfPlayerIsKilled()
    {
        if (player.isKilled())
        {
            getPlayer().setLifes(getPlayer().getLifes() - 1);
            setGameOver(true);
        }
        else if (opponent.isKilled())
        {
            getOpponent().setLifes(getOpponent().getLifes() - 1);
            setPlayerWon(true);
            setGameOver(true);
        }
    }

    @Override
    protected void updateAnimations(int delta)
    {
        updateAnimation(getMap().getBonuses(), delta);
        updateAnimation(getMap().getWalls(), delta);

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
        getOpponent().updateAnimation(delta);
    }

    @Override
    protected void updatePositions(int delta)
    {
        updatePosition(getMap().getBonuses());
        updatePosition(getMap().getWalls());
        updatePosition(getMap().getFallingWalls());
        updatePosition(getMap().getBombs());
        updatePosition(getMap().getFlames());
        if (isGameStarted())
        {
            updatePosition(getPlayer(), delta);
            updatePosition(getOpponent(), delta);
        }
        else
        {
            updatePosition((AnimatedGraphic) getPlayer());
        }
    }
}
