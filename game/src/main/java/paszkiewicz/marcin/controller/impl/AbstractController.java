package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.view.graphic.DynamicGraphic;
import paszkiewicz.marcin.view.graphic.DynamicGraphic.Movement;

public abstract class AbstractController implements Controller
{
    protected GameCore gameCore;
    
    protected Model model;
    
    public AbstractController(GameCore gameCore, Model model)
    {
        this.gameCore = gameCore;
        this.model = model;
    }
    
    public void init()
    {
    }
    
    public void checkIfMove(int keyCode, DynamicGraphic player)
    {
        if (keyCode == Input.KEY_LEFT)
        {
            player.move(Movement.LEFT);
        }
        else if (keyCode == Input.KEY_RIGHT)
        {
            player.move(Movement.RIGHT);
        }
        else if (keyCode == Input.KEY_UP)
        {
            player.move(Movement.UP);
        }
        else if (keyCode == Input.KEY_DOWN)
        {
            player.move(Movement.DOWN);
        }
    }
    
    public void checkIfStop(int keyCode, DynamicGraphic player)
    {
        if (keyCode == Input.KEY_UP && player.isMovingUp() || keyCode == Input.KEY_DOWN && player.isMovingDown()
                || keyCode == Input.KEY_LEFT && player.isMovingLeft() || keyCode == Input.KEY_RIGHT && player.isMovingRight())
        {
            player.stop();
        }
    }
}
