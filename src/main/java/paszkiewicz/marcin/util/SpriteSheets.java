package paszkiewicz.marcin.util;

import org.newdawn.slick.SpriteSheet;

import paszkiewicz.marcin.util.factory.SlickFactory;

public class SpriteSheets
{
    public static SpriteSheet basicSpriteSheet = SlickFactory.createSpriteSheet("graphics/basic_board.png", 16, 16, 1);
    
    public static SpriteSheet playerSpriteSheet = SlickFactory.createSpriteSheet("graphics/player_animation.png", 23, 23, 1);
    
    public static SpriteSheet monsterSpriteSheet = SlickFactory.createSpriteSheet("graphics/monsters_animation.png", 16, 20, 0);
}
