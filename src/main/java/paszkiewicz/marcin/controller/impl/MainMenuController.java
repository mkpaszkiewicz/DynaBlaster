package paszkiewicz.marcin.controller.impl;

import paszkiewicz.marcin.controller.Controller;

public class MainMenuController implements Controller
{
    public void serveKeyPressed(int keyCode)
    {
        System.out.println("dupa " + keyCode);
    }

    public void serveKeyReleased(int keyCode)
    {
        System.out.println(keyCode);
    }
}
