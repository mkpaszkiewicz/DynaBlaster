package paszkiewicz.marcin.server;

import java.io.Serializable;

public class Event implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public int keyCode;
    
    public boolean pressed;

    public Event(int keyCode, boolean pressed)
    {
        this.keyCode = keyCode;
        this.pressed = pressed;
    }
}
