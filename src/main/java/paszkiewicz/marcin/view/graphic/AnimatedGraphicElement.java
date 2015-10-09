package paszkiewicz.marcin.view.graphic;

import org.newdawn.slick.Animation;

public class AnimatedGraphicElement extends GraphicElement implements AnimatedGraphic
{
    public AnimatedGraphicElement(float x, float y)
    {
        super(x, y);
    }

    protected long animationLength;
    
    protected long animatingTime = 0;
    
    protected Animation animation;

    protected State state;
    
    @Override
    public void updateAnimation(int delta)
    {
        if (isAnimating())
        {
            animation.update(delta);
            
            animatingTime += delta;
            if (!animationLooped() && animatingTime >= animationLength)
            {
                setState(State.ENDED);
            }
        }
    }
    
    public void resetAnimation()
    {
        animatingTime = 0;
    }
    
    @Override
    public void setState(State state)
    {
        this.state = state;        
    }

    @Override
    public State getState()
    {
        return state;
    }

    @Override
    public boolean isAnimating()
    {
        return getState() == State.ANIMATING;
    }

    @Override
    public boolean isAnimationEnded()
    {
        return getState() == State.ENDED;
    }
    
    protected boolean animationLooped()
    {
        return animationLength == 0;
    }
}
