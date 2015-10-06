package paszkiewicz.marcin.core.impl;

import paszkiewicz.marcin.core.Core;
import paszkiewicz.marcin.model.Model;
import paszkiewicz.marcin.model.impl.GameModel;
import paszkiewicz.marcin.view.View;
import paszkiewicz.marcin.view.impl.GameView;

public class GameCore implements Core
{
    Model model;
    
    View view;
    
    public GameCore()
    {
        this.view = new GameView();
        this.model = new GameModel("Dyna Blaster");
    }
    
    public void run()
    {
        System.out.println("test");
    }
}
