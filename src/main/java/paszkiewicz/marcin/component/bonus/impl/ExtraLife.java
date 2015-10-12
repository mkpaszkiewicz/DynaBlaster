package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class ExtraLife extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setLifes(player.getLifes() + 1);
    }

    @Override
    public ExtraLife clone()
    {
        ExtraLife bonus = new ExtraLife();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setState(state);

        return bonus;
    }
}
