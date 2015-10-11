package paszkiewicz.marcin.view.graphic;

import org.newdawn.slick.Animation;

public interface AnimatedGraphic extends TiledGraphic
{
    enum AnimationState
    {
        ANIMATING, ENDED;
    }
    
    @Override
    AnimatedGraphic clone();
    
    void updateAnimation(int delta);
    
    void resetAnimation();
    
    void setState(AnimationState state);
    
    AnimationState getState();
    
    boolean isAnimating();
    
    boolean isAnimationEnded();
    
    long getAnimationLength();

    void setAnimationLength(long animationLength);

    Animation getAnimation();

    void setAnimation(Animation animation);
}
