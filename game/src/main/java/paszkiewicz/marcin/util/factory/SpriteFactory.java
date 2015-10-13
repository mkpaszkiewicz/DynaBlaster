package paszkiewicz.marcin.util.factory;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.component.sprite.Sprite;
import paszkiewicz.marcin.util.SpriteSheets;

public class SpriteFactory
{
    private static Player player = new Player();

    static
    {
        player.setMovingLeftAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 6, 0, 8, 0, 110));
        player.setMovingRightAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 3, 0, 5, 0, 110));
        player.setMovingUpAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 9, 0, 11, 0, 110));
        player.setMovingDownAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 0, 0, 2, 0, 110));
        player.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 0, 1, 6, 1, 200));
        player.setImage(player.getMovingDownAnimation().getImage(0));
    }
    
    private static Player opponent = new Player();

    static
    {
        opponent.setMovingLeftAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 6, 2, 8, 2, 110));
        opponent.setMovingRightAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 3, 2, 5, 2, 110));
        opponent.setMovingUpAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 9, 2, 11, 2, 110));
        opponent.setMovingDownAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 0, 2, 2, 2, 110));
        opponent.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 0, 3, 6, 3, 200));
        opponent.setImage(opponent.getMovingDownAnimation().getImage(0));
    }
    
    private static Sprite balloon = new Sprite();

    static
    {
        balloon.setAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 0, 0, 2, 0, 700));
        balloon.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 3, 0, 8, 0, 210));
        balloon.setImage(balloon.getAnimation().getImage(0));
        balloon.setSpeed(0.0013f);
    }

    private static Sprite broom = new Sprite();

    static
    {
        broom.setAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 0, 1, 3, 1, 450));
        broom.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 4, 1, 7, 1, 300));
        broom.setImage(broom.getAnimation().getImage(0));
        broom.setPassingThroughWalls(true);
        broom.setSpeed(0.0021f);
    }

    private static Sprite ghost = new Sprite();

    static
    {
        ghost.setAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 9, 0, 11, 0, 700));
        ghost.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 12, 0, 13, 0, 600));
        ghost.setImage(ghost.getAnimation().getImage(0));
        ghost.setPassingThroughWalls(true);
        ghost.setSpeed(0.0016f);
    }

    private static Sprite pump = new Sprite();

    static
    {
        pump.setAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 0, 2, 3, 2, 600));
        pump.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 4, 2, 7, 2, 300));
        pump.setImage(pump.getAnimation().getImage(0));
        pump.setSpeed(0.0016f);
    }

    private static Sprite stain = new Sprite();

    static
    {
        stain.setAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 0, 3, 2, 3, 700));
        stain.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 3, 3, 6, 3, 300));
        stain.setImage(stain.getAnimation().getImage(0));
        stain.setSpeed(0.00186f);
    }

    public static Player createPlayer()
    {
        return player.clone();
    }

    public static Player createOpponent()
    {
        return opponent.clone();
    }
    
    public static Sprite createBalloon()
    {
        return balloon.clone();
    }
    
    public static Sprite createBroom()
    {
        return broom.clone();
    }
    
    public static Sprite createGhost()
    {
        return ghost.clone();
    }
    
    public static Sprite createPump()
    {
        return pump.clone();
    }
    
    public static Sprite createStain()
    {
        return stain.clone();
    }
}
