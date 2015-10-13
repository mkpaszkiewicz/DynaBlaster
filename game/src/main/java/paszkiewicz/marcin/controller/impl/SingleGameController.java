package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.component.menu.MenuFieldName;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.state.GameState;

public class SingleGameController extends AbstractController
{
    public SingleGameController(GameCore gameCore, Model model)
    {
        super(gameCore, model);
    }

    public void serveKeyPressed(int keyCode)
    {
        if (keyCode == Input.KEY_ESCAPE)
        {
            if (model.getGame().isGameOver())
            {
                model.disableMenuField(MenuFieldName.RESUME);
            }
            gameCore.enterState(GameState.MAINMENU);
        }
        else if (keyCode == Input.KEY_P)
        {
            if (model.isMusicPaused())
            {
                model.resumeMusic();
            }
            else
            {
                model.pauseMusic();
            }
        }
        else if (keyCode == Input.KEY_SPACE)
        {
            model.getGame().plantBomb(model.getGame().getPlayer());
        }
        else
        {
            checkIfMove(keyCode, model.getGame().getPlayer());
        }
    }

    public void serveKeyReleased(int keyCode)
    {
        checkIfStop(keyCode, model.getGame().getPlayer());
    }
}
