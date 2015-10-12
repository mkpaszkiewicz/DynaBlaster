package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class RemoveRange extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setBombRange(player.getBombRange() - 1);
    }
    
    @Override
    public RemoveRange clone()
    {
        RemoveRange bonus = new RemoveRange();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setAnimationState(state);

        return bonus;
    }
}