package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.component.sprite.Player;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.impl.MultiplayerGame;

public class OpponentController extends AbstractController
{
    public OpponentController(GameCore gameCore, Model model)
    {
        super(gameCore, model);
    }

    @Override
    public void serveKeyPressed(int keyCode)
    {
        MultiplayerGame game = (MultiplayerGame) model.getGame();
        Player opponent = game.getOpponent();

        if (keyCode == Input.KEY_ESCAPE)
        {
            if (!game.isGameOver())
            {
                game.setGameOver(true);
                game.setPlayerWon(true);
            }
        }
        else if (keyCode == Input.KEY_SPACE)
        {
            game.plantBomb(opponent);
        }
        else
        {
            checkIfMove(keyCode, opponent);
        }
    }

    @Override
    public void serveKeyReleased(int keyCode)
    {
        MultiplayerGame game = (MultiplayerGame) model.getGame();
        Player opponent = game.getOpponent();

        checkIfStop(keyCode, opponent);
    }
}