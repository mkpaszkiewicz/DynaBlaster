package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.component.menu.MenuFieldName;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.network.ServerConnection;

public class MultiplayerController extends AbstractController
{
    private ServerConnection serverConnection;

    public MultiplayerController(GameCore gameCore, Model model)
    {
        super(gameCore, model);
    }

    @Override
    public void init()
    {
        this.serverConnection = new ServerConnection(gameCore, model);
        Thread thread = new Thread(serverConnection);
        thread.start();
    }

    public void serveKeyPressed(int keyCode)
    {
        serverConnection.send(keyCode, true);

        if (keyCode == Input.KEY_ESCAPE)
        {
            serverConnection.stop();
            model.disableMenuField(MenuFieldName.RESUME);
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
        serverConnection.send(keyCode, false);
        checkIfStop(keyCode, model.getGame().getPlayer());
    }
}
