package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;

public class Death extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        // player.setState(SpriteState.DYING);
    }
}