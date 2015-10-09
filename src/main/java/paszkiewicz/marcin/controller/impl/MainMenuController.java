package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.menu.Menu;
import paszkiewicz.marcin.menu.MenuFieldName;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.game.impl.SingleGame;
import paszkiewicz.marcin.model.game.state.GameState;

public class MainMenuController extends AbstractController
{
    public MainMenuController(GameCore gameCore, Model model)
    {
        super(gameCore, model);
    }

    public void serveKeyPressed(int keyCode)
    {
        Menu menu = model.getMenu();
        
        if (keyCode == Input.KEY_ESCAPE)
        {
            gameCore.exit();
        }
        else if (keyCode == Input.KEY_UP)
        {
            menu.previousChoice();
        }
        else if (keyCode == Input.KEY_DOWN)
        {
            menu.nextChoice();
        }
        else if (keyCode == Input.KEY_ENTER)
        {
            switch (menu.getChoice())
            {
                case MenuFieldName.RESUME:
                {
                    gameCore.enterState(GameState.SINGLEGAME);
                    break;
                }
                case MenuFieldName.SINGLE_GAME:
                {
                    model.enableMenuField(MenuFieldName.RESUME);
                    model.startNewGame(new SingleGame());
                    gameCore.enterState(GameState.SINGLEGAME);
                    break;
                }
                case MenuFieldName.MULTIPLAYER:
                {
                    model.enableMenuField(MenuFieldName.RESUME);
                    //model.startNewGame(new MultiplayerGame());
                    gameCore.enterState(GameState.MULTIPLAYER);
                    break;
                }
                case MenuFieldName.EXIT:
                {
                    gameCore.exit();
                    break;
                }
            }
        }
    }

    public void serveKeyReleased(int keyCode)
    {
    }
}
