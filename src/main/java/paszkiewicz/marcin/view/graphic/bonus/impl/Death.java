package paszkiewicz.marcin.view.graphic.bonus.impl;

import paszkiewicz.marcin.view.graphic.bonus.AbstractBonus;
import paszkiewicz.marcin.view.graphic.sprite.Player;

public class Death extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        // player.setState(SpriteState.DYING);
    }
}