package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.state.GameState;

public class MultiplayerController extends AbstractController
{
    public MultiplayerController(GameCore gameCore, Model model)
    {
        super(gameCore, model);
    }
    
    public void serveKeyPressed(int keyCode)
    {
        if (keyCode == Input.KEY_ESCAPE)
        {
            gameCore.enterState(GameState.MAINMENU);
        }
    }

    public void serveKeyReleased(int keyCode)
    {
    }
}
