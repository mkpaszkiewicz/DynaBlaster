package paszkiewicz.marcin.controller.impl;

import org.newdawn.slick.Input;

import paszkiewicz.marcin.component.Menu;
import paszkiewicz.marcin.component.MenuFieldName;
import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.core.GameCore;

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
