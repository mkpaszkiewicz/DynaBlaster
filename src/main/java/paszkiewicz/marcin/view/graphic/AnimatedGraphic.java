package paszkiewicz.marcin.view.graphic;

public interface AnimatedGraphic extends Graphic
{
    enum State
    {
        ANIMATING, ENDED;
    }
    
    void updateAnimation(int delta);
    
    void resetAnimation();
    
    void setState(State state);
    
    State getState();
    
    boolean isAnimating();
    
    boolean isAnimationEnded();
}
