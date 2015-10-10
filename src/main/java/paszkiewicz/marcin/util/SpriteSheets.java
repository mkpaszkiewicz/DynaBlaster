package paszkiewicz.marcin.util;

import org.newdawn.slick.SpriteSheet;

public class SpriteSheets
{
    private static SpriteSheet basicSpriteSheet = SlickFactory.createSpriteSheet("graphics/basic_board.png", 16, 16, 1);

    public static SpriteSheet getBasicSpriteSheet()
    {
        return basicSpriteSheet;
    }
}
