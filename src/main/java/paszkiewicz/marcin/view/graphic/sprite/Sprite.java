package paszkiewicz.marcin.view.graphic.sprite;

import org.newdawn.slick.Animation;

import paszkiewicz.marcin.view.graphic.DynamicGraphic;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class Sprite extends AnimatedGraphicElement implements DynamicGraphic
{
    protected float speed = 1;

    protected static final int DYING_TIME = 1000;

    protected boolean passingThroughWalls = false;

    protected Animation dyingAnimation;

    protected SpriteState state = SpriteState.NORMAL;

    public enum SpriteState
    {
        NORMAL, DYING, KILLED;
    }

    public Sprite()
    {
        super();
    }

    @Override
    public Sprite clone()
    {
        Sprite sprite = new Sprite();
        sprite.setAnimationLength(animationLength);
        sprite.setAnimation(animation.copy());
        sprite.setDyingAnimation(dyingAnimation.copy());
        sprite.setImage(image);
        sprite.setSpeed(speed);
        sprite.setPassingThroughWalls(passingThroughWalls);

        return sprite;
    }

    public boolean isPassingThroughWalls()
    {
        return passingThroughWalls;
    }

    public void setPassingThroughWalls(boolean passingThroughWalls)
    {
        this.passingThroughWalls = passingThroughWalls;
    }

    public void setDyingAnimation(Animation dyingAnimation)
    {
        this.dyingAnimation = dyingAnimation;
    }

    public Animation getDyingAnimation()
    {
        return dyingAnimation;
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
