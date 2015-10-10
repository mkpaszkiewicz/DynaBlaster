package paszkiewicz.marcin.util.factory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import paszkiewicz.marcin.model.game.map.Map;

public class SlickFactory
{
    public static SpriteSheet createSpriteSheet(String filename, int tileWidth, int tileHeight, int spacing)
    {
        try
        {
            return new SpriteSheet(filename, tileWidth, tileHeight, spacing);
        }
        catch (SlickException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Image createImage(String filename)
    {
        try
        {
            return new Image(filename);
        }
        catch (SlickException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Music createMusic(String filename)
    {
        try
        {
            return new Music(filename);
        }
        catch (SlickException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Map createMap(String filename)
    {
        try
        {
            return new Map(filename);
        }
        catch (SlickException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Animation createAnimation(SpriteSheet spriteSheet, int x1, int y1, int x2, int y2,
            int duration)
    {
        return new Animation(spriteSheet, x1, y1, x2, y2, true, duration, false);
    }
}
