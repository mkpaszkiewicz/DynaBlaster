package paszkiewicz.marcin.util.factory;

import org.newdawn.slick.Animation;

import paszkiewicz.marcin.util.SpriteSheets;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic.AnimationState;
import paszkiewicz.marcin.view.graphic.bonus.AbstractBonus;
import paszkiewicz.marcin.view.graphic.bonus.impl.Death;
import paszkiewicz.marcin.view.graphic.bonus.impl.ExtraBomb;
import paszkiewicz.marcin.view.graphic.bonus.impl.ExtraLife;
import paszkiewicz.marcin.view.graphic.bonus.impl.ExtraRange;
import paszkiewicz.marcin.view.graphic.bonus.impl.ExtraSpeed;
import paszkiewicz.marcin.view.graphic.bonus.impl.RemoveBomb;
import paszkiewicz.marcin.view.graphic.bonus.impl.RemoveRange;
import paszkiewicz.marcin.view.graphic.bonus.impl.RemoveSpeed;

public class BonusPrototypeFactory
{
    private static AbstractBonus extraBomb = new ExtraBomb();

    static
    {
        extraBomb.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 3, 2, 4, 2, true, 400, false));
        extraBomb.setImage(extraBomb.getAnimation().getImage(0));
        extraBomb.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus extraRange = new ExtraRange();

    static
    {
        extraRange.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 5, 2, 6, 2, true, 400, false));
        extraRange.setImage(extraRange.getAnimation().getImage(0));
        extraRange.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus extraLife = new ExtraLife();

    static
    {
        extraLife.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 7, 2, 8, 2, true, 400, false));
        extraLife.setImage(extraLife.getAnimation().getImage(0));
        extraLife.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus extraSpeed = new ExtraSpeed();

    static
    {
        extraSpeed.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 9, 2, 10, 2, true, 400, false));
        extraSpeed.setImage(extraSpeed.getAnimation().getImage(0));
        extraSpeed.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus death = new Death();

    static
    {
        death.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 11, 2, 12, 2, true, 400, false));
        death.setImage(death.getAnimation().getImage(0));
        death.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus removeBomb = new RemoveBomb();

    static
    {
        removeBomb.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 13, 2, 14, 2, true, 400, false));
        removeBomb.setImage(removeBomb.getAnimation().getImage(0));
        removeBomb.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus removeRange = new RemoveRange();

    static
    {
        removeRange.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 15, 2, 16, 2, true, 400, false));
        removeRange.setImage(removeRange.getAnimation().getImage(0));
        removeRange.setState(AnimationState.ANIMATING);
    }

    private static AbstractBonus removeSpeed = new RemoveSpeed();

    static
    {
        removeSpeed.setAnimation(new Animation(SpriteSheets.basicSpriteSheet, 17, 2, 18, 2, true, 400, false));
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
