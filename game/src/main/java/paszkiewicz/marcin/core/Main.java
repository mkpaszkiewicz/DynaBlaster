package paszkiewicz.marcin.core;

import org.newdawn.slick.SlickException;

import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.core.impl.GameCoreImpl;

public class Main
{
    public static void main(String[] args)
    {
        GameCore core = new GameCoreImpl();
        
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
