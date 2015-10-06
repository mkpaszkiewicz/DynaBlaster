package paszkiewicz.marcin.core;

import org.newdawn.slick.SlickException;

import paszkiewicz.marcin.core.impl.GameCore;

public class Main
{
    public static void main(String[] args)
    {
        Core core = new GameCore();
        
        try
        {
            core.init();
            core.run();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
}
