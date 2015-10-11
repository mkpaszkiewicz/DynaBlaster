package paszkiewicz.marcin.util.factory;

import org.newdawn.slick.Animation;

import paszkiewicz.marcin.component.Bomb;
import paszkiewicz.marcin.component.Explosion;
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
    }
    
    private static AnimatedGraphic centreExplosion = new Explosion();

    static
    {
        centreExplosion.setAnimation(SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 24, 0, 28, 0, 250));
        centreExplosion.setImage(centreExplosion.getAnimation().getImage(0));
        centreExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) centreExplosion).setPriority(2);
    }

    private static AnimatedGraphic horizontalExplosion = new Explosion();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 20, 0, 23, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        horizontalExplosion.setAnimation(animation);
        horizontalExplosion.setImage(horizontalExplosion.getAnimation().getImage(0));
        horizontalExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) horizontalExplosion).setPriority(1);
    }

    private static AnimatedGraphic verticalExplosion = new Explosion();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 16, 0, 19, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        verticalExplosion.setAnimation(animation);
        verticalExplosion.setImage(verticalExplosion.getAnimation().getImage(0));
        verticalExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) verticalExplosion).setPriority(1);
    }
    
    private static AnimatedGraphic topExplosion = new Explosion();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 8, 0, 11, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        topExplosion.setAnimation(animation);
        topExplosion.setImage(topExplosion.getAnimation().getImage(0));
        topExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) topExplosion).setPriority(0);
    }
    
    private static AnimatedGraphic bottomExplosion = new Explosion();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 0, 0, 3, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        bottomExplosion.setAnimation(animation);
        bottomExplosion.setImage(bottomExplosion.getAnimation().getImage(0));
        bottomExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) bottomExplosion).setPriority(0);
    }
    
    private static AnimatedGraphic leftExplosion = new Explosion();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 12, 0, 15, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        leftExplosion.setAnimation(animation);
        leftExplosion.setImage(leftExplosion.getAnimation().getImage(0));
        leftExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) leftExplosion).setPriority(0);
    }
    
    private static AnimatedGraphic rightExplosion = new Explosion();

    static
    {
        Animation animation = SlickFactory.createAnimation(SpriteSheets.basicSpriteSheet, 4, 0, 7, 0, 250);
        animation.addFrame(animation.getImage(3), 250);
        rightExplosion.setAnimation(animation);
        rightExplosion.setImage(rightExplosion.getAnimation().getImage(0));
        rightExplosion.setState(AnimationState.ANIMATING);
        ((Explosion) rightExplosion).setPriority(0);
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
    
    public static AnimatedGraphic createCentreExplosion()
    {
        return centreExplosion.clone();
    }
    
    public static AnimatedGraphic createHorizontalExplosion()
    {
        return horizontalExplosion.clone();
    }
    
    public static AnimatedGraphic createVerticalExplosion()
    {
        return verticalExplosion.clone();
    }
    
    public static AnimatedGraphic createTopExplosion()
    {
        return topExplosion.clone();
    }
    
    public static AnimatedGraphic createBottomExplosion()
    {
        return bottomExplosion.clone();
    }
    
    public static AnimatedGraphic createLeftExplosion()
    {
        return leftExplosion.clone();
    }
    
    public static AnimatedGraphic createRightExplosion()
    {
        return rightExplosion.clone();
    }
}
