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
        player.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.playerSpriteSheet, 0, 1, 6, 1, 150));
        player.setImage(player.getMovingDownAnimation().getImage(0));
    }

    private static Sprite balloon = new Sprite();

    static
    {
        balloon.setAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 0, 0, 2, 0, 800));
        balloon.setDyingAnimation(SlickFactory.createAnimation(SpriteSheets.monsterSpriteSheet, 3, 0, 8, 0, 180));
        balloon.setImage(balloon.getAnimation().getImage(0));
    }

    public static Player createPlayer()
    {
        return player.clone();
    }

    public static Sprite createBalloon()
    {
        return balloon.clone();
    }
}
