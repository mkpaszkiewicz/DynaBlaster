package paszkiewicz.marcin.controller.listener;

import paszkiewicz.marcin.controller.ControllerStrategy;

public class KeyListenerImpl extends KeyListenerAdapter
{   
    ControllerStrategy controllerStrategy;
    
    public KeyListenerImpl(ControllerStrategy controllerStrategy)
    {
        this.controllerStrategy = controllerStrategy;
    }
    
    @Override
    public void keyPressed(int keyCode, char c)
    {
        controllerStrategy.serveKeyPressed(keyCode);
    }

    @Override
    public void keyReleased(int keyCode, char c)
    {
        controllerStrategy.serveKeyReleased(keyCode);
    }
}
