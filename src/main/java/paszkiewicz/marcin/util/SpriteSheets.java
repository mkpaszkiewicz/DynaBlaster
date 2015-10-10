package paszkiewicz.marcin.util;

import org.newdawn.slick.SpriteSheet;

import paszkiewicz.marcin.util.factory.SlickFactory;

public class SpriteSheets
{
    public static SpriteSheet basicSpriteSheet = SlickFactory.createSpriteSheet("graphics/basic_board.png", 16, 16, 1);
}
