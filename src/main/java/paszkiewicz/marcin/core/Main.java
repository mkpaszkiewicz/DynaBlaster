package paszkiewicz.marcin.core;

import paszkiewicz.marcin.core.impl.GameCore;

public class Main
{
    public static void main(String[] args)
    {
        Core core = new GameCore();
        
        core.run();
    }
}
