package paszkiewicz.marcin.view.graphic.sprite;

import org.newdawn.slick.Image;

import paszkiewicz.marcin.view.graphic.DynamicGraphic;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class Sprite extends AnimatedGraphicElement implements DynamicGraphic
{
    protected int xTile = 0;

    protected int yTile = 0;

    protected float x = 0;

    protected float y = 0;

    protected float speed = 1;

    protected Image image;

    protected static final int DYING_TIME = 1000;

    protected long animationLength = 0;

    protected long animatingTime = 0;

    protected boolean passingThroughWalls = false;

    protected SpriteState state = SpriteState.NORMAL;

    public enum SpriteState
    {
        NORMAL, DYING, KILLED;
    }

    public Sprite()
    {
        super();
    }

    public void setSpriteState(SpriteState state)
    {
        this.state = state;
    }

    public SpriteState getSpriteState()
    {
        return state;
    }

    @Override
    public float getSpeed()
    {
        return speed;
    }

    @Override
    public void setSpeed(float speed)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveUp()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void moveDown()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveLeft()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveRight()
    {
        // TODO Auto-generated method stub

    }
}
