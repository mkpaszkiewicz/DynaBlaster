package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class RemoveBomb extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setAllAvailableBombs(player.getAllAvailableBombs() - 1);
        player.setAvailableBombs(player.getAvailableBombs() - 1);
    }
    
    @Override
    public RemoveBomb clone()
    {
        RemoveBomb bonus = new RemoveBomb();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setAnimationState(state);

        return bonus;
    }
}
