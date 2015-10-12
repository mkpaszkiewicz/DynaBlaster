package paszkiewicz.marcin.view.graphic.impl;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.view.graphic.AnimatedGraphic;

public class AnimatedGraphicElement extends GraphicElement implements AnimatedGraphic
{
    protected int xTile = 0;

    protected int yTile = 0;

    protected long animationLength = 0;

    protected long animatingTime = 0;

    protected Animation animation;

    protected AnimationState state = AnimationState.ANIMATING;

    public AnimatedGraphicElement()
    {
        super();
    }

    public AnimatedGraphicElement(int xTile, int yTile)
    {
        super();
        this.xTile = xTile;
        this.yTile = yTile;
    }

    @Override
    public void draw(Graphics graphics)
    {
        if (isAnimating())
        {
            animation.draw(x, y);
        }
        else
        {
            graphics.drawImage(image, x, y);
        }
    }

    @Override
    public AnimatedGraphicElement clone()
    {
        AnimatedGraphicElement animatedGraphicsElement = new AnimatedGraphicElement(xTile, yTile);
        animatedGraphicsElement.setAnimationLength(animationLength);
        animatedGraphicsElement.setAnimation(animation.copy());
        animatedGraphicsElement.setImage(image);
        animatedGraphicsElement.setAnimationState(state);

        return animatedGraphicsElement;
    }

    @Override
    public void updateAnimation(int delta)
    {
        if (isAnimating())
        {
            animation.update(delta);

            animatingTime += delta;
            if (!animationLooped() && animatingTime >= animationLength)
            {
                setAnimationState(AnimationState.ENDED);
            }
        }
    }

    @Override
    public void resetAnimation()
    {
        animatingTime = 0;
    }

    @Override
    public void setAnimationState(AnimationState state)
    {
        this.state = state;
    }

    @Override
    public AnimationState getAnimationState()
    {
        return state;
    }

    @Override
    public boolean isAnimating()
    {
        return getAnimationState() == AnimationState.ANIMATING;
    }

    @Override
    public boolean isAnimationEnded()
    {
        return getAnimationState() == AnimationState.ENDED;
    }

    @Override
    public int getxTile()
    {
        return xTile;
    }

    @Override
    public void setxTile(int xTile)
    {
        this.xTile = xTile;
    }

    @Override
    public int getyTile()
    {
        return yTile;
    }

    @Override
    public void setyTile(int yTile)
    {
        this.yTile = yTile;
    }

    @Override
    public long getAnimationLength()
    {
        return animationLength;
    }

    @Override
    public void setAnimationLength(long animationLength)
    {
        this.animationLength = animationLength;
    }

    @Override
    public Animation getAnimation()
    {
        return animation;
    }

    @Override
    public void setAnimation(Animation animation)
    {
        this.animation = animation;
    }

    protected boolean animationLooped()
    {
        return animationLength == 0;
    }
}
