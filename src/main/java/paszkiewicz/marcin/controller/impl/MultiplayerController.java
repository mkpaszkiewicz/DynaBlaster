package paszkiewicz.marcin.controller.impl;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.core.GameCore;

public class MultiplayerController implements Controller
{
    private GameCore gameCore;

    public MultiplayerController(GameCore gameCore)
    {
        this.gameCore = gameCore;
    }
    
    public void serveKeyPressed(int keyCode)
    {
        System.out.println(keyCode);
    }

    public void serveKeyReleased(int keyCode)
    {
        System.out.println(keyCode);
    }
}
