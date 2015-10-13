package paszkiewicz.marcin.controller.impl;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.controller.ControllerStrategy;

public class ControllerStrategyImpl implements ControllerStrategy
{
    protected Controller controller;
    
    public ControllerStrategyImpl(Controller controller)
    {
        set(controller);
    }
    
    public void set(Controller controller)
    {
        this.controller = controller;
    }

    public void serveKeyPressed(int keyCode)
    {
        controller.serveKeyPressed(keyCode);
    }

    public void serveKeyReleased(int keyCode)
    {
        controller.serveKeyReleased(keyCode);
    }
}
