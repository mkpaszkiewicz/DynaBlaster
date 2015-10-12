package paszkiewicz.marcin.component.bonus.impl;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.component.sprite.Sprite.SpriteState;

public class Death extends AbstractBonus
{
    @Override
    public void modifyFeature(Player player)
    {
        player.setSpriteState(SpriteState.DYING);
    }
    
    @Override
    public Death clone()
    {
        Death bonus = new Death();
        bonus.setAnimationLength(animationLength);
        bonus.setAnimation(animation.copy());
        bonus.setImage(image);
        bonus.setState(state);

        return bonus;
    }
}