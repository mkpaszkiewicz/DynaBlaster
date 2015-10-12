package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class RemoveSpeed extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setSpeed(player.getSpeed() + Player.EXTRA_SPEED);
    }

    @Override
    public RemoveSpeed clone()
    {
        RemoveSpeed bonus = new RemoveSpeed();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setAnimationState(state);

        return bonus;
    }
}
