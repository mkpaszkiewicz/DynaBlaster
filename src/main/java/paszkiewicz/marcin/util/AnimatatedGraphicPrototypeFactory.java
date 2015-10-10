package paszkiewicz.marcin.util;

import org.newdawn.slick.Animation;

import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class AnimatatedGraphicPrototypeFactory
{
    private static AnimatedGraphic nextStage = new AnimatedGraphicElement() {
        {
            setAnimation(new Animation(SpriteSheets.getBasicSpriteSheet(), 1, 2, 2, 2, true, 200, false));
            setImage(animation.getImage(1));
            setState(State.ENDED);
        }
    };

    private static AnimatedGraphic wall = new AnimatedGraphicElement() {
        {
            setAnimation(new Animation(SpriteSheets.getBasicSpriteSheet(), 19, 2, 20, 2, true, 200, false));
            setImage(animation.getImage(0));
            setState(State.ENDED);
        }
    };

    public static AnimatedGraphic createNextStage()
    {
        return nextStage.clone();
    }

    public static AnimatedGraphic createWall()
    {
        return wall.clone();
    }
}
