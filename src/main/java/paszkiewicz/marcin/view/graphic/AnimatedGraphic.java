package paszkiewicz.marcin.view.graphic;

import org.newdawn.slick.Animation;

public interface AnimatedGraphic extends Graphic
{
    enum State
    {
        ANIMATING, ENDED;
    }
    
    @Override
    AnimatedGraphic clone();
    
    void updateAnimation(int delta);
    
    void resetAnimation();
    
    void setState(State state);
    
    State getState();
    
    boolean isAnimating();
    
    boolean isAnimationEnded();
    
    int getxTile();

    void setxTile(int xTile);

    int getyTile();

    void setyTile(int yTile);

    long getAnimationLength();

    void setAnimationLength(long animationLength);

    long getAnimatingTime();

    void setAnimatingTime(long animatingTime);

    Animation getAnimation();

    void setAnimation(Animation animation);
}
