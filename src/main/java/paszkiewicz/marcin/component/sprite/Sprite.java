package paszkiewicz.marcin.component.sprite;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.view.graphic.DynamicGraphic;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class Sprite extends AnimatedGraphicElement implements DynamicGraphic
{
    protected float speed = 0.002f;
    
    protected float xShift = 0f;
    
    protected float yShift = 0f;
    
    protected static final int DYING_TIME = 1000;

    protected boolean passingThroughWalls = false;

    protected Animation dyingAnimation;

    protected SpriteState spriteState = SpriteState.NORMAL;

    protected Movement movement = Movement.NONE;

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
    
    @Override
    public void updateAnimation(int delta)
    {
        if (isDying())
        {
            dyingAnimation.update(delta);
            animatingTime += delta;
            if (animatingTime >= DYING_TIME)
            {
                setSpriteState(SpriteState.KILLED);
            }
        }
        else if (isMoving())
        {
            animation.update(delta);
        }
    }
    
    @Override
    public void draw(Graphics graphics)
    {
        if (isDying() && animatingTime >= DYING_TIME)
        {
            setSpriteState(SpriteState.KILLED);
        }

        if (isKilled())
        {
            return;
        }

        if (isDying())
        {
            dyingAnimation.draw(x, y);
        }
        else if (isMoving())
        {
            animation.draw(x, y);
        }
        else
        {
            graphics.drawImage(image, x, y);
        }
    }
    
    @Override
    public boolean isPassingThroughBlockedTile()
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

    public void setSpriteState(SpriteState spriteState)
    {
        this.spriteState = spriteState;
    }

    public SpriteState getSpriteState()
    {
        return spriteState;
    }

    @Override
    public float getSpeed()
    {
        return speed;
    }

    @Override
    public void setSpeed(float speed)
    {
        this.speed = speed;
    }
    
    @Override
    public void stop()
    {
        move(Movement.NONE);
    }
    
    @Override
    public void move(Movement movement)
    {
        this.movement = movement;
    }

    public boolean isMoving()
    {
        return movement != Movement.NONE;
    }

    public boolean isMovingLeft()
    {
        return movement == Movement.LEFT;
    }

    public boolean isMovingRight()
    {
        return movement == Movement.RIGHT;
    }

    public boolean isMovingUp()
    {
        return movement == Movement.UP;
    }

    public boolean isMovingDown()
    {
        return movement == Movement.DOWN;
    }

    public boolean isNormal()
    {
        return getSpriteState() == SpriteState.NORMAL;
    }

    public boolean isDying()
    {
        return getSpriteState() == SpriteState.DYING;
    }

    public boolean isKilled()
    {
        return getSpriteState() == SpriteState.KILLED;
    }
    
    @Override
    public float getxShift()
    {
        return xShift;
    }
    
    @Override
    public void setxShift(float xShift)
    {
        this.xShift = xShift;
    }

    @Override
    public float getyShift()
    {
        return yShift;
    }
    
    @Override
    public void setyShift(float yShift)
    {
        this.yShift = yShift;
    }
}