package paszkiewicz.marcin.component.bonus;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

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
        animatedGraphicsElement.setAnimation(animation.copy());
        animatedGraphicsElement.setImage(image);
        animatedGraphicsElement.setState(state);

        return animatedGraphicsElement;
    }
}
