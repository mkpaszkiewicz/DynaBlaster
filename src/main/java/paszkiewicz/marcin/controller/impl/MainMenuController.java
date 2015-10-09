package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.component.Menu;
import paszkiewicz.marcin.component.MenuFieldName;
import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.game.state.GameState;

public class MainMenuController implements Controller
{
    private GameCore gameCore;

    public MainMenuController(GameCore gameCore)
    {
        this.gameCore = gameCore;
    }

    public void serveKeyPressed(int keyCode)
    {
        Menu menu = gameCore.getModel().getMenu();

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
                    menu.setFieldVisibility(0, true);
                    // create new game
                    gameCore.enterState(GameState.SINGLEGAME);
                    break;
                }
                case MenuFieldName.MULTIPLAYER:
                {
                    menu.setFieldVisibility(0, true);
                    // create new multiplayer game
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
