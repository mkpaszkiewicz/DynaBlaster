package paszkiewicz.marcin.util.factory;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.util.SpriteSheets;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic.AnimationState;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class AnimatatedGraphicPrototypeFactory
{
    private static AnimatedGraphic bomb = new Bomb();

    static
    {
        bomb.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 36, 0, 38, 0, 200));
        bomb.setImage(bomb.getAnimation().getImage(0));
        bomb.setState(AnimationState.ANIMATING);
        bomb.setAnimationLength(2500);
    }

    private static AnimatedGraphic nextStage = new AnimatedGraphicElement();

    static
    {
        nextStage.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 1, 2, 2, 2, 200));
        nextStage.setImage(nextStage.getAnimation().getImage(1));
        nextStage.setState(AnimationState.ENDED);
    }

    private static AnimatedGraphic wall = new AnimatedGraphicElement();

    static
    {
        wall.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 19, 2, 20, 2, 200));
        wall.setImage(wall.getAnimation().getImage(0));
        wall.setState(AnimationState.ENDED);
    }

    private static AnimatedGraphic fallingWall = new AnimatedGraphicElement();

    static
    {
        fallingWall.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 29, 0, 35, 0, 150));
        fallingWall.setImage(fallingWall.getAnimation().getImage(0));
        fallingWall.setState(AnimationState.ANIMATING);
        fallingWall.setAnimationLength(1000);
    }
    
    public static AnimatedGraphic createBomb()
    {
        return bomb.clone();
    }
    
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
