package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class ExtraSpeed extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setSpeed(player.getSpeed() + Player.EXTRA_SPEED);
    }
    
    @Override
    public ExtraSpeed clone()
    {
        ExtraSpeed bonus = new ExtraSpeed();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setState(state);

        return bonus;
    }
}
