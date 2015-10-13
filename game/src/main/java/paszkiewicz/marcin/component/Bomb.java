package paszkiewicz.marcin.component;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class Bomb extends AnimatedGraphicElement
{
    protected Player owner;

    public Bomb()
    {
        super();
    }
    
    @Override
    public Bomb clone()
    {
            Bomb bomb = new Bomb();
            bomb.setAnimationLength(animationLength);
            bomb.setAnimation(animation.copy());
            bomb.setImage(image);
            bomb.setAnimationState(state);

            return bomb;
    }
    
    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player owner)
    {
        this.owner = owner;
    }
}
