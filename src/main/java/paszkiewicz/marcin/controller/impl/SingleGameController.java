package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.state.GameState;
import paszkiewicz.marcin.view.graphic.DynamicGraphic.Movement;

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
        else if (keyCode == Input.KEY_LEFT)
        {
            model.getGame().getPlayer().move(Movement.LEFT);
        }
        else if (keyCode == Input.KEY_RIGHT)
        {
            model.getGame().getPlayer().move(Movement.RIGHT);
        }
        else if (keyCode == Input.KEY_UP)
        {
            model.getGame().getPlayer().move(Movement.UP);
        }
        else if (keyCode == Input.KEY_DOWN)
        {
            model.getGame().getPlayer().move(Movement.DOWN);
        }
        else if (keyCode == Input.KEY_SPACE)
        {
            model.getGame().plantBomb(model.getGame().getPlayer());
        }
    }

    public void serveKeyReleased(int keyCode)
    {
        Player player = model.getGame().getPlayer();

        if (keyCode == Input.KEY_UP && player.isMovingUp() || keyCode == Input.KEY_DOWN && player.isMovingDown()
                || keyCode == Input.KEY_LEFT && player.isMovingLeft() || keyCode == Input.KEY_RIGHT && player.isMovingRight())
        {
            player.stop();
        }
    }
}
