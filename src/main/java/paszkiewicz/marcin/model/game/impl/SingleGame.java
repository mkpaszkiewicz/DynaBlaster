package paszkiewicz.marcin.model.game.impl;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.component.sprite.PlayerToken;
import paszkiewicz.marcin.model.game.Game;
import paszkiewicz.marcin.model.map.LayerName;
import paszkiewicz.marcin.model.map.Map;
import paszkiewicz.marcin.util.factory.MapFactory;
import paszkiewicz.marcin.util.factory.SpriteFactory;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;

public class SingleGame implements Game
{
    protected static int NUMBER_OF_STAGES = 10;

    protected int stageNumber = 1;

    protected Map map;

    protected Player player;
    
    protected PlayerToken playerToken;
    
    protected boolean gameOver = false;

    protected boolean playerWon = false;

    public SingleGame()
    {
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
    public void draw(Graphics graphics)
    {
        map.render((int) map.getX(), (int) map.getY(), map.getLayerIndex(LayerName.BACKGROUND));
        map.getNextStage().draw(graphics);
        for (AnimatedGraphic bonus : map.getBonuses())
        {
            bonus.draw(graphics);
        }
        for (AnimatedGraphic wall : map.getWalls())
        {
            wall.draw(graphics);
        }
        player.draw(graphics);
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

    protected void updateAnimations(int delta)
    {
        map.getNextStage().updateAnimation(delta);
        
        for (AnimatedGraphic bonus : map.getBonuses())
        {
            bonus.updateAnimation(delta);
        }
        
        for (AnimatedGraphic wall : map.getWalls())
        {
            wall.updateAnimation(delta);
        }
        
        player.updateAnimation(delta);
    }

    protected void updatePositions(int delta)
    {
        updatePosition(map.getNextStage());
        
        for (AnimatedGraphic bonus : map.getBonuses())
        {
            updatePosition(bonus);
        }
        
        for (AnimatedGraphic wall : map.getWalls())
        {
            updatePosition(wall);
        }

        updatePosition(player);        
    }

    protected void updatePosition(AnimatedGraphic animatedGraphic)
    {
        float x = (int) (map.getX() + animatedGraphic.getxTile() * map.getTileWidth());
        float y = (int) (map.getY() + animatedGraphic.getyTile() * map.getTileHeight());
        animatedGraphic.setX(x);
        animatedGraphic.setY(y);
    }
    
    protected void updatePosition(Player player)
    {
        float x = (int) (map.getX() + player.getxTile() * map.getTileWidth() - 3);
        float y = (int) (map.getY() + player.getyTile() * map.getTileHeight() - 7);
        player.setX(x);
        player.setY(y);
    }
}
