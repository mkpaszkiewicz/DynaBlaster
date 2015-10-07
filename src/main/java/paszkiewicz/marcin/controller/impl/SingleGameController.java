package paszkiewicz.marcin.controller.impl;

import paszkiewicz.marcin.controller.Controller;

public class SingleGameController implements Controller
{
    public void serveKeyPressed(int keyCode)
    {
        System.out.println(keyCode);
    }

    public void serveKeyReleased(int keyCode)
    {
        System.out.println(keyCode);
    }
}
