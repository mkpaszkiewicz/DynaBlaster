package paszkiewicz.marcin.view.graphic.bonus;

import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;
import paszkiewicz.marcin.view.graphic.sprite.Player;

public class AbstractBonus extends AnimatedGraphicElement implements Bonus
{      
    public AbstractBonus()
    {
        super();
    }

    public AbstractBonus(int xTile, int yTile)
    {
        super(xTile, yTile);
    }
    
    public void modifyFeature(Player player)
    {
    }
    
    @Override
    public AbstractBonus clone()
    {
        AbstractBonus animatedGraphicsElement = new AbstractBonus(xTile, yTile);
        animatedGraphicsElement.setAnimationLength(animationLength);
        animatedGraphicsElement.setAnimatingTime(animatingTime);
        animatedGraphicsElement.setAnimation(animation.copy());
        animatedGraphicsElement.setImage(image);
        animatedGraphicsElement.setState(state);

        return animatedGraphicsElement;
    }
}
