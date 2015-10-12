package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class ExtraBomb extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setAllAvailableBombs(player.getAllAvailableBombs() + 1);
        player.setAvailableBombs(player.getAvailableBombs() + 1);
    }
    
    @Override
    public ExtraBomb clone()
    {
        ExtraBomb bonus = new ExtraBomb();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setState(state);

        return bonus;
    }
}
