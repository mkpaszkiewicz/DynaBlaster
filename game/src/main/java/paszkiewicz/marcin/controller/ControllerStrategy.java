package paszkiewicz.marcin.controller;

public interface ControllerStrategy
{
    public void set(Controller controller);
    
    public void serveKeyPressed(int keyCode);
    
    public void serveKeyReleased(int keyCode);
}
