package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class ExtraRange extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setBombRange(player.getBombRange() + 1);
    }

    @Override
    public ExtraRange clone()
    {
        ExtraRange bonus = new ExtraRange();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setState(state);

        return bonus;
    }
}
