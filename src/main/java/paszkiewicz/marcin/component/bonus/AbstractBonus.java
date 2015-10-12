package paszkiewicz.marcin.component.bonus;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class AbstractBonus extends AnimatedGraphicElement implements Bonus
{
    public AbstractBonus()
    {
        super();
    }

    public void modifyFeature(Player player)
    {
    }

    @Override
    public AbstractBonus clone()
    {
        AbstractBonus bonus = new AbstractBonus();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setAnimationState(state);

        return bonus;
    }
}
