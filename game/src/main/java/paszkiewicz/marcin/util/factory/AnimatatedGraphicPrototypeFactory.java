package paszkiewicz.marcin.util.factory;

import org.newdawn.slick.Animation;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.component.Flame;
import paszkiewicz.marcin.util.SpriteSheets;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic;
import paszkiewicz.marcin.view.graphic.AnimatedGraphic.AnimationState;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;

public class AnimatatedGraphicPrototypeFactory
{
    private static int FLAME_ANIMATION_LENGTH = 1000;
    
    private static AnimatedGraphic bomb = new Bomb();

    static
    {
        bomb.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 36, 0, 38, 0, 200));
        bomb.setImage(bomb.getAnimation().getImage(0));
        bomb.setAnimationState(AnimationState.ANIMATING);
        bomb.setAnimationLength(2500);
    }

    private static AnimatedGraphic nextStage = new AnimatedGraphicElement();

    static
    {
        nextStage.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 1, 2, 2, 2, 200));
        nextStage.setImage(nextStage.getAnimation().getImage(1));
        nextStage.setAnimationState(AnimationState.ENDED);
    }

    private static AnimatedGraphic wall = new AnimatedGraphicElement();

    static
    {
        wall.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 19, 2, 20, 2, 250));
        wall.setImage(wall.getAnimation().getImage(0));
        wall.setAnimationState(AnimationState.ENDED);
    }

    private static AnimatedGraphic fallingWall = new AnimatedGraphicElement();

    static
    {
        fallingWall.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 29, 0, 35, 0, 170));
        fallingWall.setImage(fallingWall.getAnimation().getImage(0));
        fallingWall.setAnimationState(AnimationState.ANIMATING);
        fallingWall.setAnimationLength(FLAME_ANIMATION_LENGTH);
    }
    
    private static AnimatedGraphic centreFlame = new Flame();

    static
    {
        centreFlame.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 24, 0, 28, 0, 250));
        centreFlame.setImage(centreFlame.getAnimation().getImage(0));
        centreFlame.setAnimationState(AnimationState.ANIMATING);
        centreFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) centreFlame).setPriority(2);
    }

    private static AnimatedGraphic horizontalFlame = new Flame();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 20, 0, 23, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        horizontalFlame.setAnimation(animation);
        horizontalFlame.setImage(horizontalFlame.getAnimation().getImage(0));
        horizontalFlame.setAnimationState(AnimationState.ANIMATING);
        horizontalFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) horizontalFlame).setPriority(1);
    }

    private static AnimatedGraphic verticalFlame = new Flame();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 16, 0, 19, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        verticalFlame.setAnimation(animation);
        verticalFlame.setImage(verticalFlame.getAnimation().getImage(0));
        verticalFlame.setAnimationState(AnimationState.ANIMATING);
        verticalFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) verticalFlame).setPriority(1);
    }
    
    private static AnimatedGraphic topFlame = new Flame();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 0, 0, 3, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        topFlame.setAnimation(animation);
        topFlame.setImage(topFlame.getAnimation().getImage(0));
        topFlame.setAnimationState(AnimationState.ANIMATING);
        topFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) topFlame).setPriority(0);
    }
    
    private static AnimatedGraphic bottomFlame = new Flame();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 8, 0, 11, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        bottomFlame.setAnimation(animation);
        bottomFlame.setImage(bottomFlame.getAnimation().getImage(0));
        bottomFlame.setAnimationState(AnimationState.ANIMATING);
        bottomFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) bottomFlame).setPriority(0);
    }
    
    private static AnimatedGraphic leftFlame = new Flame();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 12, 0, 15, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        leftFlame.setAnimation(animation);
        leftFlame.setImage(leftFlame.getAnimation().getImage(0));
        leftFlame.setAnimationState(AnimationState.ANIMATING);
        leftFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) leftFlame).setPriority(0);
    }
    
    private static AnimatedGraphic rightFlame = new Flame();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 4, 0, 7, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        rightFlame.setAnimation(animation);
        rightFlame.setImage(rightFlame.getAnimation().getImage(0));
        rightFlame.setAnimationState(AnimationState.ANIMATING);
        rightFlame.setAnimationLength(FLAME_ANIMATION_LENGTH);
        ((Flame) rightFlame).setPriority(0);
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
    
    public static AnimatedGraphic createCentreFlame()
    {
        return centreFlame.clone();
    }
    
    public static AnimatedGraphic createHorizontalFlame()
    {
        return horizontalFlame.clone();
    }
    
    public static AnimatedGraphic createVerticalFlame()
    {
        return verticalFlame.clone();
    }
    
    public static AnimatedGraphic createTopFlame()
    {
        return topFlame.clone();
    }
    
    public static AnimatedGraphic createBottomFlame()
    {
        return bottomFlame.clone();
    }
    
    public static AnimatedGraphic createLeftFlame()
    {
        return leftFlame.clone();
    }
    
    public static AnimatedGraphic createRightFlame()
    {
        return rightFlame.clone();
    }
}
