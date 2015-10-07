package paszkiewicz.marcin.core;

import org.newdawn.slick.SlickException;

import paszkiewicz.marcin.model.Model;

public interface GameCore
{
    void init() throws SlickException;
    
    void run() throws SlickException;
    
    void exit();
    
    Model getModel();
}
