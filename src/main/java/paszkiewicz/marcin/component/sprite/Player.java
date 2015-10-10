package paszkiewicz.marcin.component.sprite;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public class Player extends Sprite
{
    protected static final float STARTING_SPEED = 0.047f;

    protected static final float EXTRA_SPEED = 0.008f;

    protected static final int STARTING_LIFES = 2;

    protected static final int STARTING_BOMBS = 1;

    protected static final int STARTING_BOMB_RANGE = 1;

    protected int allAvailableBombs = STARTING_BOMBS;

    protected int availableBombs = STARTING_BOMBS;

    protected int bombRange = STARTING_BOMB_RANGE;

    protected int lifes = STARTING_LIFES;

    protected Animation movingLeftAnimation, movingRightAnimation, movingUpAnimation, movingDownAnimation;

    public Player()
    {
        setSpeed(STARTING_SPEED);
    }

    @Override
    public Player clone()
    {
        Player sprite = new Player();
        sprite.setMovingLeftAnimation(movingLeftAnimation.copy());
        sprite.setMovingRightAnimation(movingRightAnimation.copy());
        sprite.setMovingUpAnimation(movingUpAnimation.copy());
        sprite.setMovingDownAnimation(movingDownAnimation.copy());
        sprite.setDyingAnimation(dyingAnimation.copy());
        sprite.setImage(image);
        sprite.setSpeed(speed);
        sprite.setPassingThroughWalls(passingThroughWalls);

        return sprite;
    }

    public PlayerToken createToken()
    {
        PlayerToken token = new PlayerToken();
        token.setRememberedAllAvailableBombs(allAvailableBombs);
        token.setRememberedBombRange(bombRange);
        token.setRememberedSpeed(speed);

        return token;
    }

    public void restoreState(PlayerToken token)
    {
        setAllAvailableBombs(token.getRememberedAllAvailableBombs());
        setBombRange(token.getRememberedBombRange());
        setSpeed(token.getRememberedSpeed());
    }

    @Deprecated
    @Override
    public Animation getAnimation()
    {
        return super.getAnimation();
    }

    @Deprecated
    @Override
    public void setAnimation(Animation animation)
    {
        super.setAnimation(animation);
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
        else if (isMovingLeft())
        {
            movingLeftAnimation.update(delta);
        }
        else if (isMovingRight())
        {
            movingRightAnimation.update(delta);
        }
        else if (isMovingUp())
        {
            movingUpAnimation.update(delta);
        }
        else if (isMovingDown())
        {
            movingDownAnimation.update(delta);
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
        else if (isMovingLeft())
        {
            movingLeftAnimation.draw(x, y);
        }
        else if (isMovingRight())
        {
            movingRightAnimation.draw(x, y);
        }
        else if (isMovingUp())
        {
            movingUpAnimation.draw(x, y);
        }
        else if (isMovingDown())
        {
            movingDownAnimation.draw(x, y);
        }
        else
        {
            graphics.drawImage(image, x, y);
        }
    }

    public Animation getMovingLeftAnimation()
    {
        return movingLeftAnimation;
    }

    public void setMovingLeftAnimation(Animation movingLeftAnimation)
    {
        this.movingLeftAnimation = movingLeftAnimation;
    }

    public Animation getMovingRightAnimation()
    {
        return movingRightAnimation;
    }

    public void setMovingRightAnimation(Animation movingRightAnimation)
    {
        this.movingRightAnimation = movingRightAnimation;
    }

    public Animation getMovingUpAnimation()
    {
        return movingUpAnimation;
    }

    public void setMovingUpAnimation(Animation movingUpAnimation)
    {
        this.movingUpAnimation = movingUpAnimation;
    }

    public Animation getMovingDownAnimation()
    {
        return movingDownAnimation;
    }

    public void setMovingDownAnimation(Animation movingDownAnimation)
    {
        this.movingDownAnimation = movingDownAnimation;
    }

    public int getAllAvailableBombs()
    {
        return allAvailableBombs;
    }

    public void setAllAvailableBombs(int allAvailableBombs)
    {
        this.allAvailableBombs = allAvailableBombs;
    }

    public int getAvailableBombs()
    {
        return availableBombs;
    }

    public void setAvailableBombs(int availableBombs)
    {
        this.availableBombs = availableBombs;
    }

    public int getBombRange()
    {
        return bombRange;
    }

    public void setBombRange(int bombRange)
    {
        this.bombRange = bombRange;
    }

    public int getLifes()
    {
        return lifes;
    }

    public void setLifes(int lifes)
    {
        this.lifes = lifes;
    }
}
