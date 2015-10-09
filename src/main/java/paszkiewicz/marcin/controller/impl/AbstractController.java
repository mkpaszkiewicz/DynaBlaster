package paszkiewicz.marcin.controller.impl;

import paszkiewicz.marcin.controller.Controller;
import paszkiewicz.marcin.core.GameCore;
import paszkiewicz.marcin.model.Model;

public abstract class AbstractController implements Controller
{
    protected GameCore gameCore;
    
    protected Model model;
    
    public AbstractController(GameCore gameCore, Model model)
    {
        this.gameCore = gameCore;
        this.model = model;
    }
}
