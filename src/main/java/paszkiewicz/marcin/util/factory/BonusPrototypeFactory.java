package paszkiewicz.marcin.util.factory;

import paszkiewicz.marcin.component.bonus.AbstractBonus;
import paszkiewicz.marcin.component.bonus.impl.Death;
import paszkiewicz.marcin.component.bonus.impl.ExtraBomb;
import paszkiewicz.marcin.component.bonus.impl.ExtraLife;
import paszkiewicz.marcin.component.bonus.impl.ExtraRange;
import paszkiewicz.marcin.component.bonus.impl.ExtraSpeed;
import paszkiewicz.marcin.component.bonus.impl.RemoveBomb;
import paszkiewicz.marcin.component.bonus.impl.RemoveRange;
import paszkiewicz.marcin.component.bonus.impl.RemoveSpeed;
import paszkiewicz.marcin.util.SpriteSheets;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic.AnimationState;

public class BonusPrototypeFactory
{
    private static AbstractBonus extraBomb = new ExtraBomb();

    static
    {
        extraBomb.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 3, 2, 4, 2, 400));
        extraBomb.setImage(extraBomb.getAnimation().getImage(0));
        extraBomb.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus extraRange = new ExtraRange();

    static
    {
        extraRange.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 5, 2, 6, 2, 400));
        extraRange.setImage(extraRange.getAnimation().getImage(0));
        extraRange.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus extraLife = new ExtraLife();

    static
    {
        extraLife.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 7, 2, 8, 2, 400));
        extraLife.setImage(extraLife.getAnimation().getImage(0));
        extraLife.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus extraSpeed = new ExtraSpeed();

    static
    {
        extraSpeed.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 9, 2, 10, 2, 400));
        extraSpeed.setImage(extraSpeed.getAnimation().getImage(0));
        extraSpeed.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus death = new Death();

    static
    {
        death.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 11, 2, 12, 2, 400));
        death.setImage(death.getAnimation().getImage(0));
        death.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus removeBomb = new RemoveBomb();

    static
    {
        removeBomb.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 13, 2, 14, 2, 400));
        removeBomb.setImage(removeBomb.getAnimation().getImage(0));
        removeBomb.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus removeRange = new RemoveRange();

    static
    {
        removeRange.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 15, 2, 16, 2, 400));
        removeRange.setImage(removeRange.getAnimation().getImage(0));
        removeRange.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus removeSpeed = new RemoveSpeed();

    static
    {
        removeSpeed.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 17, 2, 18, 2, 400));
        removeSpeed.setImage(removeSpeed.getAnimation().getImage(0));
        removeSpeed.setState(AnimationState.ANIMATING);
    }

    public static AbstractBonus createDeath()
    {
        return death.clone();
    }

    public static AbstractBonus createExtraBomb()
    {
        return extraBomb.clone();
    }

    public static AbstractBonus createExtraLife()
    {
        return extraLife.clone();
    }

    public static AbstractBonus createExtraRange()
    {
        return extraRange.clone();
    }

    public static AbstractBonus createExtraSpeed()
    {
        return extraSpeed.clone();
    }

    public static AbstractBonus createRemoveBomb()
    {
        return removeBomb.clone();
    }

    public static AbstractBonus createRemoveRange()
    {
        return removeRange.clone();
    }

    public static AbstractBonus createRemoveSpeed()
    {
        return removeSpeed.clone();
    }
}
