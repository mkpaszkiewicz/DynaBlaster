package paszkiewicz.marcin.view.graphic.bonus;

import paszkiewicz.marcin.model.game.AnimatedGameObject;
import paszkiewicz.marcin.util.GameObjectVisitor;
import paszkiewicz.marcin.view.graphic.impl.AnimatedGraphicElement;
import paszkiewicz.marcin.view.graphic.sprite.Player;

public abstract class Bonus extends AnimatedGraphicElement implements AnimatedGameObject
{
    public abstract void modifyFeature(Player player);
    
    @Override
    public void applyVisitor(GameObjectVisitor visitor)
    {
        visitor.visit(this);        
    }
}
