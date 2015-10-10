package paszkiewicz.marcin.util.factory;

import paszkiewicz.marcin.util.SpriteSheets;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class AnimatatedGraphicPrototypeFactory
{
    private static AnimatedGraphic nextStage = new AnimatedGraphicElement() {
        {
            setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 1, 2, 2, 2, 200));
            setImage(animation.getImage(1));
            setState(AnimationState.ENDED);
        }
    };

    private static AnimatedGraphic wall = new AnimatedGraphicElement() {
        {
            setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 19, 2, 20, 2, 200));
            setImage(animation.getImage(0));
            setState(AnimationState.ENDED);
        }
    };

    private static AnimatedGraphic fallingWall = new AnimatedGraphicElement() {
        {
            setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 29, 0, 35, 0, 150));
            setImage(animation.getImage(0));
            setState(AnimationState.ANIMATING);
            setAnimationLength(1000);
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

    public static AnimatedGraphic createFallingWall()
    {
        return fallingWall.clone();
    }
}
